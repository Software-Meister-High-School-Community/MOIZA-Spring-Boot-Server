package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.follow.spi.FollowQueryUserSpi;

public interface UserSpi extends QueryUserSpi, CommandUserSpi, FollowQueryUserSpi {

}
