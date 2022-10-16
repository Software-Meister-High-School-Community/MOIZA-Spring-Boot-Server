package com.moiza.moizaspringbootserver.domain.like.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.domain.like.domain.repository.FeedLikeRepository;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.like.spi.FeedLikeSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class FeedLikePersistenceAdapter implements FeedLikeSpi {
    private final FeedMapper feedMapper;
    private final FeedLikeRepository feedLikeRepository;

    @Override
    public void deleteFeedLike(Feed feed) {
        feedLikeRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }
}
