package feed.usecase;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.api.response.LocalFeedResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.QueryLocalFeedSpi;
import com.moiza.moizaspringbootserver.feed.usecase.LocalFeedListUseCase;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class LocalFeedListUseCaseTest {

    @Mock
    QueryUserSpi queryUserSpi;

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @Mock
    QueryLocalFeedSpi queryLocalFeedSpi;

    @InjectMocks
    LocalFeedListUseCase localFeedListUseCase;

    @Test
    void 조회_성공() {
        /*ser user = User.builder()
                .id(UUID.randomUUID())
                .build();

        List<LocalFeed> expected = List.of(
            LocalFeed.builder()
                    .feedId(UUID.randomUUID())
                    .title("테스트 개시글")
                    .createdAt(LocalDateTime.now())
                    .build()
        );

        given(authSecuritySpi.getCurrentUserId()).willReturn(user.getId());
        given(queryUserSpi.queryUserById(user.getId())).willReturn(user);
        given(queryLocalFeedSpi.getAllLocalFeedByTypeAndKeyword(
                FeedType.COMMON, ""
        )).willReturn();*/
    }

}
