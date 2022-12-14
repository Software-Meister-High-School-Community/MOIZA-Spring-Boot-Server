package com.moiza.moizaspringbootserver.domain.like.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.domain.like.domain.FeedLikeId;
import com.moiza.moizaspringbootserver.domain.like.domain.repository.FeedLikeRepository;
import com.moiza.moizaspringbootserver.domain.like.mapper.FeedLikeMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.like.FeedLike;
import com.moiza.moizaspringbootserver.like.exception.FeedLikeNotFoundException;
import com.moiza.moizaspringbootserver.like.spi.FeedLikeSpi;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class FeedLikePersistenceAdapter implements FeedLikeSpi {
    private final FeedMapper feedMapper;
    private final FeedLikeRepository feedLikeRepository;
    private final FeedLikeMapper feedLikeMapper;

    @Override
    public void saveFeedLike(FeedLike feedLike) {
        feedLikeRepository.save(
                feedLikeMapper.feedLikeDomainToEntity(feedLike)
        );
    }

    @Override
    public void deleteFeedLike(FeedLike feedLike) {
        feedLikeRepository.delete(feedLikeMapper.feedLikeDomainToEntity(feedLike));
    }

    @Override
    public void deleteAllFeedLikeByFeed(Feed feed) {
        feedLikeRepository.deleteAllByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public boolean existsByFeedIdAndUserId(UUID feedId, UUID userId) {
        try {
            getFeedLike(feedId, userId);
            return true;
        } catch (FeedLikeNotFoundException exception) {
            return false;
        }
    }

    @Override
    public FeedLike getFeedLike(UUID feedId, UUID userId) {
        return feedLikeMapper.feedLikeEntityToDomain(feedLikeRepository.findById(new FeedLikeId(userId, feedId, LocalDateTime.now()))
                .orElseThrow(() -> FeedLikeNotFoundException.EXCEPTION));
    }
}
