package com.moiza.moizaspringbootserver.auth.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenRefreshResponse {
    private final String accessToken;
    private final Long expiredAt;
    private final String refreshToken;
}
