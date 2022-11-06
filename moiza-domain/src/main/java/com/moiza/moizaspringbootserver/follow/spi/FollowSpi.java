package com.moiza.moizaspringbootserver.follow.spi;

import com.moiza.moizaspringbootserver.user.domain.User;

public interface FollowSpi extends CommandFollowSpi, QueryFollowSpi {

    Long getFollowCount(User user);
}
