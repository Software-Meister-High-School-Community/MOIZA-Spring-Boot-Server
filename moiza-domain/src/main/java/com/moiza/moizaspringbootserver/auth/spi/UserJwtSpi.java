package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.auth.spi.dto.TokenResponse;
import java.util.UUID;

public interface UserJwtSpi {
	TokenResponse getToken(String email);
}
