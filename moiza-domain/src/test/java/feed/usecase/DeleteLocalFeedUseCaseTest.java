package feed.usecase;

import com.moiza.moizaspringbootserver.auth.exception.InvalidRoleException;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.spi.feed.QueryFeedSpi;
import com.moiza.moizaspringbootserver.feed.usecase.DeleteLocalFeedUseCase;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DeleteLocalFeedUseCaseTest {

    @Mock
    QueryFeedSpi queryFeedSpi;

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @Mock
    QueryUserSpi queryUserSpi;

    @InjectMocks
    DeleteLocalFeedUseCase deleteLocalFeedUseCase;

    @Test
    void 임시게시글_삭제() {

        UUID feedId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        given(authSecuritySpi.getCurrentUserId())
                .willReturn(userId);
        given(queryFeedSpi.getFeedById(feedId))
                .willReturn(Feed.builder().build());
        given(queryUserSpi.existsUserById(userId))
                .willReturn(true);

        deleteLocalFeedUseCase.execute(feedId);
    }

    @Test
    void 내_임시저장_게시글() {
        UUID userId = UUID.randomUUID();

        given(queryUserSpi.existsUserById(userId))
                .willReturn(false);

        assertThrows(InvalidRoleException.class, () -> deleteLocalFeedUseCase.execute(userId));
    }
}
