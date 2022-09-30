package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.user.api.GraduateVerificationApi;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainGraduateVerificationRequest;
import com.moiza.moizaspringbootserver.user.domain.GraduateVerifyingFile;
import com.moiza.moizaspringbootserver.user.spi.CommandGraduateVerifyingFileSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class GraduateVerificationUseCase implements GraduateVerificationApi {

    private final CommandGraduateVerifyingFileSpi commandGraduateVerifyingFileSpi;
    private final AuthSecuritySpi authSecuritySpi;

    @Override
    public void execute(DomainGraduateVerificationRequest request) {
        UUID userId = authSecuritySpi.getCurrentUserId();

        GraduateVerifyingFile graduateVerifyingFile = GraduateVerifyingFile.builder()
                .userId(userId)
                .verifyingFileUrl(request.getVerifyingFileUrl())
                .build();

        commandGraduateVerifyingFileSpi.saveGraduateVerifyingFile(graduateVerifyingFile);
    }
}
