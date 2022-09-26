package com.moiza.moizaspringbootserver.auth.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SendEmailAuthCodeResponse {

    private final String email;
}
