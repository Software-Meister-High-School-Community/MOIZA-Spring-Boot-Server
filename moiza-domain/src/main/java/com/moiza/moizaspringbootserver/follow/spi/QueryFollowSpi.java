package com.moiza.moizaspringbootserver.follow.spi;

import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.user.domain.User;

import java.util.UUID;

public interface QueryFollowSpi {
	Follow queryFollowByTargetUserId(UUID userId, UUID targetUserId);

	Long getFollowCount(User user);

}