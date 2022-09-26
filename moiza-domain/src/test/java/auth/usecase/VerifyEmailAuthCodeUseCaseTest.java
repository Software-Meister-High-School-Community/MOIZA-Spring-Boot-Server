package auth.usecase;

import com.moiza.moizaspringbootserver.auth.domain.EmailCode;
import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import com.moiza.moizaspringbootserver.auth.spi.CommandEmailCodeSpi;
import com.moiza.moizaspringbootserver.auth.spi.QueryEmailCodeSpi;
import com.moiza.moizaspringbootserver.auth.usecase.VerifyEmailAuthCodeUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class VerifyEmailAuthCodeUseCaseTest {

    @Mock
    QueryEmailCodeSpi queryEmailCodeSpi;

    @Mock
    CommandEmailCodeSpi commandEmailCodeSpi;

    @InjectMocks
    VerifyEmailAuthCodeUseCase verifyEmailAuthCodeUseCase;

    @Test
    void 이메일_검증_확인() {
        String email = "이멜";
        String authCode ="123456";
        Type type = Type.SIGNUP;
        EmailCode emailCode = EmailCode.builder()
                .isVerify(false)
                .build();

        given(queryEmailCodeSpi.queryEmailCodeByEmailAndType(email, type))
                .willReturn(emailCode);

        commandEmailCodeSpi.saveAuthCode(emailCode);

        verifyEmailAuthCodeUseCase.execute(email, authCode, type);
    }
}
