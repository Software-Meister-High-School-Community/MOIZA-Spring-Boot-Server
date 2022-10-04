package com.moiza.moizaspringbootserver.follow.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.follow.api.DeleteFollowApi;
import com.moiza.moizaspringbootserver.follow.sqi.CommandFollowSpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowAuthSecuritySpi;
import com.moiza.moizaspringbootserver.follow.sqi.FollowQueryUserSpi;
import com.moiza.moizaspringbootserver.follow.sqi.QueryFollowSpi;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class DeleteFollowUseCase implements DeleteFollowApi {

	private final FollowAuthSecuritySpi followAuthSecuritySpi;
	private final FollowQueryUserSpi followQueryUserSpi;
	private final CommandFollowSpi commandFollowSpi;
	private final QueryFollowSpi queryFollowSpi;

	@Override
	public void execute(UUID userId) {

		UUID currentUserId = followAuthSecuritySpi.getCurrentUserId();
		followQueryUserSpi.queryUserById(userId);

		Follow follow = queryFollowSpi.queryFollowByTargetUserId(userId, currentUserId);
		commandFollowSpi.deleteFollow(follow);
	}
}
