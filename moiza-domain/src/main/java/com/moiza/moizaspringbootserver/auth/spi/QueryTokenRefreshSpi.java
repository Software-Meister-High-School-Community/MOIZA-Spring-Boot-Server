package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.auth.RefreshToken;

public interface QueryTokenRefreshSpi {
    RefreshToken queryRefreshTokenByToken(String token);
}
