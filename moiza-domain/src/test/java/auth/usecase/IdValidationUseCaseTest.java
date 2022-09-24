package auth.usecase;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.user.exception.UserAlredayExistException;
import com.moiza.moizaspringbootserver.auth.spi.IdValidationSpi;
import com.moiza.moizaspringbootserver.auth.usecase.IdValidationUseCase;
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
    IdValidationSpi idValidationSpi;

    @InjectMocks
    IdValidationUseCase idValidationUseCase;

    @Test
    void 중복_아이디() {
        String userId = "userid";
        DomainIdValidationRequest request = new DomainIdValidationRequest(userId);

        given(idValidationSpi.isUserExists(userId))
                .willReturn(true);

        assertThrows(UserAlredayExistException.class, () -> idValidationUseCase.execute(request));
    }

    @Test
    void 사용가능_아이디() {
        String userId = "userid";
        DomainIdValidationRequest request = new DomainIdValidationRequest(userId);

        given(idValidationSpi.isUserExists(userId))
                .willReturn(false);

        idValidationUseCase.execute(request);
    }


}
