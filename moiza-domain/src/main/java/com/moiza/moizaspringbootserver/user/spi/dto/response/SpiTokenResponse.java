package com.moiza.moizaspringbootserver.user.spi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpiTokenResponse {
    private final String accessToken;
    private final Long refreshExp;
    private final String refreshToken;
}
