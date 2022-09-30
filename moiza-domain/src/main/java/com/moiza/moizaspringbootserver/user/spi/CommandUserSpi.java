package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.domain.User;

import java.util.UUID;

public interface CommandUserSpi {
	void saveUser(User user);
	void deleteUserById(UUID uuid);
}
