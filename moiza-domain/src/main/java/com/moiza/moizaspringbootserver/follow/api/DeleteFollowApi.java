package com.moiza.moizaspringbootserver.follow.api;

import java.util.UUID;

public interface DeleteFollowApi {
	void execute(UUID userId);
}
