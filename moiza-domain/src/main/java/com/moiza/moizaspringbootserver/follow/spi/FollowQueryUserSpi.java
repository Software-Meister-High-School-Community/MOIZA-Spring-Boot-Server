package com.moiza.moizaspringbootserver.follow.spi;

import com.moiza.moizaspringbootserver.user.domain.User;
import java.util.UUID;

public interface FollowQueryUserSpi {
	User queryUserById(UUID userId);
}
