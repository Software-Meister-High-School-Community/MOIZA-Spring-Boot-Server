package com.moiza.moizaspringbootserver.domain.feed.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.feed.spi.QueryFeedSqi;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class QueryFeedPersistenceAdapter implements QueryFeedSqi {

    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Override
    public Long getUserFeeCount(User user) {
        UserEntity userId = userRepository.findById(user.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return feedRepository.countAllByUser(userId);
    }
}
