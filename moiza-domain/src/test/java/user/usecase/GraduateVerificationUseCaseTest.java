package user.usecase;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainGraduateVerificationRequest;
import com.moiza.moizaspringbootserver.user.domain.GraduateVerifyingFile;
import com.moiza.moizaspringbootserver.user.spi.CommandGraduateVerifyingFileSpi;
import com.moiza.moizaspringbootserver.user.usecase.GraduateVerificationUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class GraduateVerificationUseCaseTest {

    @Mock
    AuthSecuritySpi authSecuritySpi;

    @Mock
    CommandGraduateVerifyingFileSpi commandGraduateVerifyingFileSpi;

    @Mock
    DomainGraduateVerificationRequest request;

    @InjectMocks
    GraduateVerificationUseCase graduateVerificationUseCase;

    @Test
    void 졸업생인증() {
        UUID userId = authSecuritySpi.getCurrentUserId();
        String verifyingFileUrl = "인증파일";
        GraduateVerifyingFile graduateVerifyingFile = GraduateVerifyingFile.builder()
                .userId(userId)
                .verifyingFileUrl(verifyingFileUrl)
                .build();

        commandGraduateVerifyingFileSpi.saveGraduateVerifyingFile(graduateVerifyingFile);

        graduateVerificationUseCase.execute(request);
    }
}
