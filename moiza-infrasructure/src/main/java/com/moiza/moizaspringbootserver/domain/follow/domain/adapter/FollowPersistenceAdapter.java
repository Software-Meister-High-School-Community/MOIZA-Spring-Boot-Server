package com.moiza.moizaspringbootserver.domain.follow.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.follow.domain.FollowEntity;
import com.moiza.moizaspringbootserver.domain.follow.domain.repository.FollowRepository;
import com.moiza.moizaspringbootserver.domain.follow.mapper.FollowMapper;
import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.follow.exception.FollowNotFoundException;
import com.moiza.moizaspringbootserver.follow.sqi.FollowSpi;
import java.util.UUID;
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

	@Override
	public void deleteFollow(Follow follow) {
		followRepository.delete(
			followMapper.followDomainToEntity(follow)
		);
	}

	@Override
	public Follow queryFollowByTargetUserId(UUID userId, UUID targetUserId) {
		FollowEntity followEntity = followRepository
			.findByUserEntityIdAndTargetUserId(userId, targetUserId)
			.orElseThrow(() -> FollowNotFoundException.EXCEPTION);

		return followMapper.followEntityToDomain(followEntity);
	}

    @Override
    public Long getFollowCount(User user) {
        UserEntity userId = userRepository.findById(user.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return followRepository.countAllByUserEntity(userId);
    }
}