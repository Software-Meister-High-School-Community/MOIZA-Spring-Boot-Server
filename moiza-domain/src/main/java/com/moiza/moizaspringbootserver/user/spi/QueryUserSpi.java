package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.domain.User;

public interface QueryUserSpi {
	boolean existsUserByAccountId(String accountId);
	boolean existsUserByEmail(String email);
	String queryGetEmailByAccountId(String accountId);
	User queryUserByAccountId(String accountId);
	User getUserByEmail(String email);
}
