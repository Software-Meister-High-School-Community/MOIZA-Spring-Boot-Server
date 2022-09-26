package com.moiza.moizaspringbootserver.auth.api;

import com.moiza.moizaspringbootserver.auth.api.dto.response.TokenRefreshResponse;

public interface TokenRefreshApi {
    TokenRefreshResponse execute(String token);
}
