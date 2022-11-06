package com.moiza.moizaspringbootserver.follow.spi;

import java.util.UUID;

public interface FollowAuthSecuritySpi {
	UUID getCurrentUserId();
}
