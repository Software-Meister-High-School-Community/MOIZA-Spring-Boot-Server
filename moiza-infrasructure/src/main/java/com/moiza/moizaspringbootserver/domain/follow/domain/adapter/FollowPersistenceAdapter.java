package com.moiza.moizaspringbootserver.domain.follow.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.follow.domain.repository.FollowRepository;
import com.moiza.moizaspringbootserver.domain.follow.mapper.FollowMapper;
import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.follow.sqi.FollowSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class FollowPersistenceAdapter implements FollowSpi {

	private final FollowMapper followMapper;
	private final FollowRepository followRepository;

	@Override
	public void saveFollow(Follow follow) {
		followRepository.save(
			followMapper.followDomainToEntity(follow)
		);
	}
}
