package com.moiza.moizaspringbootserver.user.api;

import com.moiza.moizaspringbootserver.user.api.dto.request.DomainGraduateVerificationRequest;

public interface GraduateVerificationApi {
    void execute(DomainGraduateVerificationRequest request);
}
