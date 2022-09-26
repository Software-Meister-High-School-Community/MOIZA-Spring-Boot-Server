package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.user.domain.UserDeviceToken;

public interface CommandUserDeviceTokenSpi {
	void saveUserDeviceToken(UserDeviceToken userDeviceToken);
}
