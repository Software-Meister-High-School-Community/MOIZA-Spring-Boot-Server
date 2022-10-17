package com.moiza.moizaspringbootserver.follow.api;

import java.util.UUID;

public interface CancelFollowApi {
	void execute(UUID userId);
}
