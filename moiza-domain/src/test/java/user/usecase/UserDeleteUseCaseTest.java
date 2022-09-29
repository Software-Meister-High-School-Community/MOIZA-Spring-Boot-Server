package user.usecase;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.auth.exception.UserAuthQueryFailedException;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import com.moiza.moizaspringbootserver.user.usecase.UserDeleteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class UserDeleteUseCaseTest {

    @Mock
    CommandUserSpi commandUserSpi;

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @InjectMocks
    UserDeleteUseCase userDeleteUseCase;

    @Test
    void 사용자_탈퇴_실패_JWT_실패() {
        given(authSecuritySpi.getCurrentUserId()).willThrow(UserAuthQueryFailedException.class);

        assertThrows(UserAuthQueryFailedException.class, () -> userDeleteUseCase.execute());
    }

    @Test
    void 사용자_탈퇴_실패_찾을수_없는_사용자() {
        UUID uuid = UUID.randomUUID();
        given(authSecuritySpi.getCurrentUserId()).willReturn(uuid);
        doThrow(UserNotFoundException.class).when(commandUserSpi).deleteUserById(uuid);

        assertThrows(UserNotFoundException.class, () -> userDeleteUseCase.execute());
    }

    @Test
    void 사용자_탈퇴_성공() {
        UUID uuid = UUID.randomUUID();
        given(authSecuritySpi.getCurrentUserId()).willReturn(uuid);

        userDeleteUseCase.execute();
    }
}
