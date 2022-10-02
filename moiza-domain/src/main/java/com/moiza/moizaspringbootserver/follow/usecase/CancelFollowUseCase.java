package com.moiza.moizaspringbootserver.follow.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.follow.api.CancelFollowApi;
import com.moiza.moizaspringbootserver.follow.sqi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowQueryUserSpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowAuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.sqi.QueryFollowSpi;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CancelFollowUseCase implements CancelFollowApi {

	private final FollowQueryUserSpi followQueryUserSpi;
	private final QueryFollowSpi queryFollowPort;
	private final FollowAuthSecuritySpi followAuthSecuritySpi;
	private final CommandFollowSpi commandFollowSpi;

	@Override
	public void execute(UUID userId) {
		UUID currentUserId = followAuthSecuritySpi.getCurrentUserId();
		followQueryUserSpi.queryUserById(userId);

		Follow follow = queryFollowPort.queryFollowByTargetUserId(currentUserId, userId);
		commandFollowSpi.deleteFollow(follow);
	}
}
