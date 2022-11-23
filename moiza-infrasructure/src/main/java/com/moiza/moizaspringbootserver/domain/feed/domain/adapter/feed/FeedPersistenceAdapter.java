package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.feed;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedRepository;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.exception.FeedNotFoundException;
import com.moiza.moizaspringbootserver.feed.spi.feed.FeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Adapter
public class FeedPersistenceAdapter implements FeedSpi {

    private final FeedRepository feedRepository;
    private final UserRepository userRepository;
    private final FeedMapper feedMapper;

    @Override
    public Long getUserFeeCount(User user) {
        UserEntity userId = userRepository.findById(user.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return feedRepository.countAllByUser(userId);
    }

    @Override
    public void deleteFeedByFeedId(Feed feed) {
        feedRepository.delete(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public Feed getFeedById(UUID feedId) {
        return feedMapper.feedEntityToDomain(feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION));
    }

    @Override
    public List<Feed> getMyFeedListByUserIdAndFeedTypeAndCategoryAndOrder(UUID userId, FeedType type, String category, QueryOrders order, int page) {
        return null;
    }
}
