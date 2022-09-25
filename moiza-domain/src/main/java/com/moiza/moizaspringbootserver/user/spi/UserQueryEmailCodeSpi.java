package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.auth.EmailCode;

public interface UserQueryEmailCodeSpi {
	EmailCode queryEmailCodeById(String email);
}
