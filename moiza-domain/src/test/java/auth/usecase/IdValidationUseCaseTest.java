package auth.usecase;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.auth.usecase.IdValidationUseCase;
import com.moiza.moizaspringbootserver.user.exception.UserAlreadyExistsException;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class IdValidationUseCaseTest {

    @Mock
    QueryUserSpi queryUserSpi;

    @InjectMocks
    IdValidationUseCase idValidationUseCase;

    @Test
    void 중복_아이디() {
        String userId = "userid";
        DomainIdValidationRequest request = new DomainIdValidationRequest(userId);

        given(queryUserSpi.existsUserByAccountId(userId))
                .willReturn(true);

        assertThrows(UserAlreadyExistsException.class, () -> idValidationUseCase.execute(request));
    }

    @Test
    void 사용가능_아이디() {
        String userId = "userid";
        DomainIdValidationRequest request = new DomainIdValidationRequest(userId);

        given(queryUserSpi.existsUserByAccountId(userId))
                .willReturn(false);

        idValidationUseCase.execute(request);
    }


}
