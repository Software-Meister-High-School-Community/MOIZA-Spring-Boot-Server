package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.follow.sqi.FollowQueryUserSpi;

public interface UserSpi extends QueryUserSpi, CommandUserSpi, FollowQueryUserSpi {

}
