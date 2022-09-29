package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.api.dto.response.SearchAllUsersResponse;
import com.moiza.moizaspringbootserver.user.domain.User;

import java.util.UUID;

public interface QueryUserSpi {
	boolean existsUserByAccountId(String accountId);
	boolean existsUserByEmail(String email);
	String queryGetEmailByAccountId(String accountId);
	User queryUserByAccountId(String accountId);
	User getUserByEmail(String email);
  	User queryUserById(UUID userId);
	SearchAllUsersResponse querySearchAllUsers(String name, Integer page);
}
