package user.usecase;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.domain.SearchHistory;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.HistoryPermissionDeniedException;
import com.moiza.moizaspringbootserver.user.exception.SearchHistoryNotFoundException;
import com.moiza.moizaspringbootserver.user.spi.QuerySearchHistorySpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.usecase.UserSearchHistoryDeleteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserSearchHistoryDeleteUseCaseTest {

    @Mock
    QueryUserSpi queryUserSpi;

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @Mock
    QuerySearchHistorySpi querySearchHistorySpi;

    @InjectMocks
    UserSearchHistoryDeleteUseCase userSearchHistoryDeleteUseCase;

    @Test
    void 삭제_실패_조회불가() {
        User user = User.builder()
                .id(UUID.randomUUID())
                .build();

        UUID queryId = UUID.randomUUID();

        given(authSecuritySpi.getCurrentUserId()).willReturn(user.getId());
        given(queryUserSpi.queryUserById(user.getId())).willReturn(user);
        given(querySearchHistorySpi.querySearchHistoryById(queryId)).willThrow(SearchHistoryNotFoundException.EXCEPTION);

        assertThrows(SearchHistoryNotFoundException.class, () -> userSearchHistoryDeleteUseCase.execute(queryId));
    }

    @Test
    void 삭제_실패_권한부족() {
        User user = User.builder()
                .id(UUID.randomUUID())
                .build();

        SearchHistory history = SearchHistory.builder()
                .id(UUID.randomUUID())
                .userId(UUID.randomUUID())
                .build();

        given(authSecuritySpi.getCurrentUserId()).willReturn(user.getId());
        given(queryUserSpi.queryUserById(user.getId())).willReturn(user);
        given(querySearchHistorySpi.querySearchHistoryById(history.getId())).willReturn(history);

        assertThrows(HistoryPermissionDeniedException.class, () -> userSearchHistoryDeleteUseCase.execute(history.getId()));
    }

    @Test
    void 삭제_성공() {
        User user = User.builder()
                .id(UUID.randomUUID())
                .build();

        SearchHistory history = SearchHistory.builder()
                .id(UUID.randomUUID())
                .userId(user.getId())
                .build();

        given(authSecuritySpi.getCurrentUserId()).willReturn(user.getId());
        given(queryUserSpi.queryUserById(user.getId())).willReturn(user);
        given(querySearchHistorySpi.querySearchHistoryById(history.getId())).willReturn(history);

        userSearchHistoryDeleteUseCase.execute(history.getId());
    }
}
