package com.moiza.moizaspringbootserver.domain.feed.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.spi.feed.FeedSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class FeedPersistenceAdapter implements FeedSpi {

    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Override
    public Long getUserFeeCount(User user) {
        UserEntity userId = userRepository.findById(user.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return feedRepository.countAllByUser(userId);
    }

    @Override
    public void feedDelete(Feed feed) {


    }

    @Override
    public void feedAttachmentFileDelete(Feed feed) {

    }

    @Override
    public void localFeedDelete(Feed feed) {

    }

    @Override
    public void publicFeedDelete(Feed feed) {

    }
}
