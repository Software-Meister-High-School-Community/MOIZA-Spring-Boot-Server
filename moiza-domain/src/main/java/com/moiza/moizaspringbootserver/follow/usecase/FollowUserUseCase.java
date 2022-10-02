package com.moiza.moizaspringbootserver.follow.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.follow.api.FollowUserApi;
import com.moiza.moizaspringbootserver.follow.sqi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowQueryUserSpi;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class FollowUserUseCase implements FollowUserApi {

	private final FollowQueryUserSpi followQueryUserSpi;
	private final AuthSecuritySpi authSecuritySpi;
	private final CommandFollowSpi commandFollowSpi;

	@Override
	public void execute(UUID userId) {
		UUID currentUserId = authSecuritySpi.getCurrentUserId();
		followQueryUserSpi.queryUserById(userId);

		Follow follow = Follow.builder()
			.userId(currentUserId)
			.targetUserId(userId)
			.build();

		commandFollowSpi.saveFollow(follow);
	}
}
