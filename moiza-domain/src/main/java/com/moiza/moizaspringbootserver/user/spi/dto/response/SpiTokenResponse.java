package com.moiza.moizaspringbootserver.user.spi.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpiTokenResponse {
    private final String accessToken;
    private final Long refreshExp;
    private final String refreshToken;
}
