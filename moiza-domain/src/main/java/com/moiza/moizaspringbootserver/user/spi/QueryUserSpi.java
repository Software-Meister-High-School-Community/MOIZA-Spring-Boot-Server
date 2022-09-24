package com.moiza.moizaspringbootserver.user.spi;

public interface QueryUserSpi {
	boolean existsUserByAccountId(String accountId);
	boolean existsUserByEmail(String email);
}
