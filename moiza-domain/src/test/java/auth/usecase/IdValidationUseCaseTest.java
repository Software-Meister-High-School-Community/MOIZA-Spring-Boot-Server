package auth.usecase;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.auth.exception.UserAlredayExistException;
import com.moiza.moizaspringbootserver.auth.spi.IdValidationSpi;
import com.moiza.moizaspringbootserver.auth.usecase.IdValidationUseCase;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("중복된 아이디 제공")
    @Test
    void whenDuplicatedServed() {
        String userId = "userid";
        DomainIdValidationRequest request = DomainIdValidationRequest.builder()
                .accountId(userId)
                .build();

        given(idValidationSpi.isUserExists(userId))
                .willReturn(true);

        assertThrows(UserAlredayExistException.class, () -> idValidationUseCase.validId(request));
    }

    @DisplayName("중복되지 아니한 아이디 제공")
    @Test
    void whenValidServed() {
        String userId = "userid";
        DomainIdValidationRequest request = DomainIdValidationRequest.builder()
                .accountId(userId)
                .build();

        given(idValidationSpi.isUserExists(userId))
                .willReturn(false);

        idValidationUseCase.validId(request);
    }


}
