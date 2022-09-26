package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.auth.domain.RefreshToken;

public interface CommandRefreshTokenSpi {
	void saveRefreshToken(RefreshToken refreshToken);
}
