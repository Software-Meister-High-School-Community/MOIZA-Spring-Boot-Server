package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.User;

public interface QueryUserSpi {
    User getUserByEmail(String email);
}
