package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.User;

public interface CommandUserSpi {
	void saveUser(User user);
}