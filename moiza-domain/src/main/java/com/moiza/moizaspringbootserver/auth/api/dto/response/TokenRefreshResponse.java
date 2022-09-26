package com.moiza.moizaspringbootserver.auth.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenRefreshResponse {
    private final String accessToken;
    private final Long expiredAt;
    private final String refreshToken;
}
