package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.user.UserDeviceToken;

public interface CommandUserDeviceTokenSpi {
	void saveUserDeviceToken(UserDeviceToken userDeviceToken);
}
