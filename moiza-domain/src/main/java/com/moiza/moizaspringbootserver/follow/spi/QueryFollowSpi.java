package com.moiza.moizaspringbootserver.follow.spi;

import com.moiza.moizaspringbootserver.user.domain.User;

public interface QueryFollowSpi {
    Long getFollowCount(User user);
}
