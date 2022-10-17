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

    @Override
    public FollowEntity followDomainToEntity(Follow follow) {
        UserEntity userEntity = userRepository.findById(follow.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        UserEntity targetUserEntity = userRepository.findById(follow.getTargetUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return FollowEntity.builder()
            .followId(
                FollowId.builder()
                    .user(follow.getUserId())
                    .createdAt(follow.getCreatedAt())
                    .targetUser(follow.getTargetUserId())
                    .build()
            )
            .userEntity(userEntity)
            .targetUser(targetUserEntity)
            .createdAt(follow.getCreatedAt())
            .build();
    }

    @Override
    public Follow followEntityToDomain(FollowEntity followEntity) {
        return Follow.builder()
                .userId(followEntity.getUserEntity().getId())
                .createdAt(followEntity.getCreatedAt())
                .targetUserId(followEntity.getTargetUser().getId())
                .build();
    }
}
