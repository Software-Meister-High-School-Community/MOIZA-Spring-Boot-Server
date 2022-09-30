package com.moiza.moizaspringbootserver.user.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainGraduateVerificationRequest {

    private final String verifyingFileUrl;
}
