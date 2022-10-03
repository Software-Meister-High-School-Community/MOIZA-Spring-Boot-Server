package com.moiza.moizaspringbootserver.domain.follow.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.follow.domain.repository.FollowRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.follow.spi.FollowSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class FollowPersistenceAdapter implements FollowSpi {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Override
    public Long getFollowCount(User user) {
        UserEntity userId = userRepository.findById(user.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return followRepository.countAllByUserEntity(userId);
    }
}
