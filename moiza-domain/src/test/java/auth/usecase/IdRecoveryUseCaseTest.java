package auth.usecase;

import com.moiza.moizaspringbootserver.auth.api.dto.response.IdRecoveryResponse;
import com.moiza.moizaspringbootserver.auth.usecase.IdRecoveryUseCase;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class IdRecoveryUseCaseTest {

    @Mock
    QueryUserSpi queryUserSpi;

    @InjectMocks
    IdRecoveryUseCase idRecoveryUseCase;

    @Test
    void 아이디찾기_실패() {
        String email = "email@gmail.com";

        given(queryUserSpi.getUserByEmail(email))
                .willThrow(UserNotFoundException.EXCEPTION);

        assertThrows(UserNotFoundException.class,
                () -> idRecoveryUseCase.execute(email));
    }

    @Test
    void 아이디찾기_성공() {
        User user = User.builder()
                .name("누군가")
                .email("email@gmail.com")
                .accountId("accountId")
                .build();

        IdRecoveryResponse expected = IdRecoveryResponse.builder()
                .name(user.getName())
                .accountId(user.getAccountId())
                .build();

        given(queryUserSpi.getUserByEmail(user.getEmail()))
                .willReturn(user);

        IdRecoveryResponse actual = idRecoveryUseCase.execute(user.getEmail());

        assertEquals(expected.getAccountId(), actual.getAccountId());
        assertEquals(expected.getName(), actual.getName());
    }

}
