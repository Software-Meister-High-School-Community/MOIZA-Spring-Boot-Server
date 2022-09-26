package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.auth.spi.dto.TokenResponse;

public interface UserJwtSpi {
	TokenResponse getToken(String email);
}
