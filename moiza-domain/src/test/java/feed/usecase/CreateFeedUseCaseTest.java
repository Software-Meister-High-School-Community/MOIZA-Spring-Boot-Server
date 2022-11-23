package feed.usecase;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.Category;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.api.dto.request.DomainCreateFeedRequest;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.feed.CommandFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.feedattachmentfile.CommandFeedAttachmentFileSpi;
import com.moiza.moizaspringbootserver.feed.spi.feedcategory.QueryFeedCategorySpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedSpi;
import com.moiza.moizaspringbootserver.feed.usecase.CreateFeedUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CreateFeedUseCaseTest {

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @Mock
    CommandFeedSpi commandFeedSpi;

    @Mock
    PublicFeedSpi publicFeedSpi;

    @Mock
    QueryFeedCategorySpi queryFeedCategorySpi;

    @Mock
    CommandFeedAttachmentFileSpi commandFeedAttachmentFileSpi;

    @InjectMocks
    CreateFeedUseCase createFeedUseCase;

    private final UUID userId = UUID.randomUUID();

    private final Feed feed = Feed.builder()
            .feedType(FeedType.COMMON)
            .userId(userId)
            .build();

    @Test
    void 생성_성공() {

        given(authSecuritySpi.getCurrentUserId())
                .willReturn(userId);
        given(queryFeedCategorySpi.queryCategoryByCategoryName("Category"))
                .willReturn(
                        Category.builder()
                                .id(UUID.randomUUID())
                                .categoryName("Category")
                                .build()
                );
        given(commandFeedSpi.saveFeed(feed))
                .willReturn(
                        Feed.builder()
                                .id(UUID.randomUUID())
                                .feedType(FeedType.COMMON)
                                .userId(userId)
                                .build()
                );

        createFeedUseCase.execute(
                DomainCreateFeedRequest.builder()
                        .title("title")
                        .content("content")
                        .feedType(FeedType.COMMON)
                        .category("Category")
                        .imageUrls(List.of())
                        .build()
        );
    }
}
