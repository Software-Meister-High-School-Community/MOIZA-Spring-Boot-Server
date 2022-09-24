package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.User;

public interface CommandUserPort {
	void saveUser(User user);
}
