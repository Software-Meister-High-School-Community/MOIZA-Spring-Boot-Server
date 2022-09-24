package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.auth.EmailCode;

public interface UserQueryEmailCodePort {
	EmailCode queryEmailCodeById(String email);
}
