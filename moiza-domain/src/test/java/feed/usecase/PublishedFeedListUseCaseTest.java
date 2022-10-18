package feed.usecase;

import com.moiza.moizaspringbootserver.feed.PublicFeed;
import com.moiza.moizaspringbootserver.feed.api.dto.response.PublishedFeedListResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedQuerySpi;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedResponse;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;
import com.moiza.moizaspringbootserver.feed.usecase.PublishedFeedListUseCase;
import com.moiza.moizaspringbootserver.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PublishedFeedListUseCaseTest {

    @Mock
    private PublicFeedQuerySpi publicFeedQuerySpi;

    @InjectMocks
    private PublishedFeedListUseCase publishedFeedListUseCase;

    @Test
    void 조회성공() {
        User user = User.builder()
                .id(UUID.randomUUID())
                .build();

        PublicFeed publicFeed = PublicFeed.builder()
                .feedId(UUID.randomUUID())
                .viewCount(1000)
                .likeCount(100)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        PublishedFeedResponse publishedFeedResponse = PublishedFeedResponse.builder()
                .feed(publicFeed)
                .type(FeedType.COMMON)
                .liked(true)
                .commentCount(0)
                .build();

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd`'T'`hh:mm:ss");
        PublishedFeedPage page = PublishedFeedPage.builder()
                .feeds(List.of(publishedFeedResponse))
                .totalPages(1L)
                .build();

        PublishedFeedListResponse expected = PublishedFeedListResponse.builder()
                .feedList(List.of(
                        com.moiza.moizaspringbootserver.feed.api.dto.response.PublishedFeedResponse.builder()
                                .id(publishedFeedResponse.getFeed().getFeedId())
                                .commentCount(publishedFeedResponse.getCommentCount())
                                .liked(publishedFeedResponse.getLiked())
                                .createdAt(formatter.format(publishedFeedResponse.getFeed().getCreatedAt()))
                                .likeCount(publishedFeedResponse.getFeed().getLikeCount())
                                .viewCount(publishedFeedResponse.getFeed().getViewCount())
                                .type(publishedFeedResponse.getType())
                                .build()
                ))
                .totalPage(1L)
                .build();


        given(publicFeedQuerySpi.execute(user.getId(), "테스트", publishedFeedResponse.getType(), QueryOrders.LATEST, 0))
                .willReturn(page);

        assertEquals(expected.getFeedList().get(0), publishedFeedListUseCase.execute(user.getId(), "테스트", publishedFeedResponse.getType().name(), "LATEST", 0).getFeedList().get(0));
    }

}
