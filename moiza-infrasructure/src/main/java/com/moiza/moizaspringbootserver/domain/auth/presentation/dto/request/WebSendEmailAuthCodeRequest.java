package com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request;

import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebSendEmailAuthCodeRequest {

    @NotBlank
    private Type type;

    @NotBlank
    private String value;
}
