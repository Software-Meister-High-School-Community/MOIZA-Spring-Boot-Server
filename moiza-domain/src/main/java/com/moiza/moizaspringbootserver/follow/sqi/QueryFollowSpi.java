package com.moiza.moizaspringbootserver.follow.sqi;

import com.moiza.moizaspringbootserver.follow.Follow;
import java.util.UUID;

public interface QueryFollowSpi {
	Follow queryFollowByTargetUserId(UUID userId, UUID targetUserId);
}