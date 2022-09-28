package com.moiza.moizaspringbootserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebGraduateVerificationRequest {

    @NotBlank
    private String verifyingFileUrl;
}
