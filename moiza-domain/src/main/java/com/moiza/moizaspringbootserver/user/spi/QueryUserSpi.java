package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.User;

public interface QueryUserSpi {
	boolean existsUserByAccountId(String accountId);
	boolean existsUserByEmail(String email);
	User getUserByEmail(String email);
}
