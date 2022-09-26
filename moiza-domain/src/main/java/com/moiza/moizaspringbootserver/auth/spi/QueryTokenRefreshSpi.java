package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.auth.domain.RefreshToken;

public interface QueryTokenRefreshSpi {
    RefreshToken queryRefreshTokenByToken(String token);
}
