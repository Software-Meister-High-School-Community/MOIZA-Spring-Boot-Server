package com.moiza.moizaspringbootserver.domain.follow.mapper;

import com.moiza.moizaspringbootserver.domain.follow.domain.FollowEntity;
import com.moiza.moizaspringbootserver.domain.follow.domain.FollowId;
import com.moiza.moizaspringbootserver.domain.follow.domain.repository.FollowRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.follow.Follow;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FollowMapperImpl implements FollowMapper{

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    @Override
    public FollowEntity followDomainToEntity(Follow follow) {
        UserEntity userId = userRepository.findById(follow.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        FollowEntity followEntity = followRepository.findByFollowIdAndTargetUser(userId, userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return new FollowEntity(
                FollowId.builder()
                        .user(userId.getId())
                        .createdAt(follow.getCreatedAt())
                        .targetUser(followEntity.getTargetUser().getId())
                        .build()
        );


    }

    @Override
    public Follow followEntityToDomain(FollowEntity followEntity) {
        return Follow.builder()
                .userId(followEntity.getFollowId().getUser())
                .createdAt(followEntity.getCreatedAt())
                .targetUserId(followEntity.getTargetUser().getId())
                .build();
    }
}
