package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.User;

import java.util.UUID;

public interface QueryUserSpi {
	boolean existsUserByAccountId(String accountId);
	boolean existsUserByEmail(String email);

	User queryUserById(UUID userId);
}
