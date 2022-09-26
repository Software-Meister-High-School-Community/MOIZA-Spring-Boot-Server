package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.auth.domain.EmailCode;

public interface UserQueryEmailCodeSpi {
	EmailCode queryEmailCodeById(String email);
}
