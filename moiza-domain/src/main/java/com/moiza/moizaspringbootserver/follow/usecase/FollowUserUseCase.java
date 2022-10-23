package com.moiza.moizaspringbootserver.follow.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.follow.api.FollowUserApi;
import com.moiza.moizaspringbootserver.follow.spi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.spi.FollowAuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.spi.FollowQueryUserSpi;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class FollowUserUseCase implements FollowUserApi {

	private final FollowQueryUserSpi followQueryUserSpi;
	private final FollowAuthSecuritySpi followAuthSecuritySpi;
	private final CommandFollowSpi commandFollowSpi;

	@Override
	public void execute(UUID userId) {
		UUID currentUserId = followAuthSecuritySpi.getCurrentUserId();
		followQueryUserSpi.queryUserById(userId);

		Follow follow = Follow.builder()
			.userId(currentUserId)
			.targetUserId(userId)
			.build();

		commandFollowSpi.saveFollow(follow);
	}
}
