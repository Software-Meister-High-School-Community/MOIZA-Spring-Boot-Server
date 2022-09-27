package user.usecase;

import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserQueryFailedException;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.usecase.UserDeleteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserDeleteUseCaseTest {

    @Mock
    CommandUserSpi commandUserSpi;

    @Mock
    QueryUserSpi queryUserSpi;

    @InjectMocks
    UserDeleteUseCase userDeleteUseCase;

    @Test
    void 사용자_탈퇴_실패() {
        given(queryUserSpi.queryCurrentUser()).willThrow(UserQueryFailedException.class);

        assertThrows(UserQueryFailedException.class, () -> userDeleteUseCase.execute());
    }

    @Test
    void 사용자_탈퇴_성공() {
        User user = User.builder()
                .accountId("accountId")
                .email("email@gmail.com")
                .build();

        given(queryUserSpi.queryCurrentUser()).willReturn(user);

        userDeleteUseCase.execute();
    }
}
