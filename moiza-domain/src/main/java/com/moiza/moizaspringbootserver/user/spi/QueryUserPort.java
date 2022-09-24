package com.moiza.moizaspringbootserver.user.spi;

public interface QueryUserPort {
	boolean existsUserByAccountId(String accountId);
	boolean existsUserByEmail(String email);
}
