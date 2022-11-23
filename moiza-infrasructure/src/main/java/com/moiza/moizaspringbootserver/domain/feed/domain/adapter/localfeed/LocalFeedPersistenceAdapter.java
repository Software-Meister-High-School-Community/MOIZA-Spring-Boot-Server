package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.localfeed;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.LocalFeedRepository;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom.LocalFeedCustomRepository;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.domain.feed.mapper.LocalFeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.exception.LocalFeedNotFoundException;
import com.moiza.moizaspringbootserver.feed.exception.FeedNotFoundException;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.LocalFeedSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class LocalFeedPersistenceAdapter implements LocalFeedSpi {

    private final FeedMapper feedMapper;
    private final LocalFeedMapper localFeedMapper;
    private final LocalFeedRepository localFeedRepository;
    private final LocalFeedCustomRepository localFeedCustomRepository;

    @Override
    public void deleteLocalFeedByFeedId(Feed feed) {
        localFeedRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public List<LocalFeed> getAllLocalFeedByTypeAndKeyword(User user, FeedType type, String keyword) {
        return localFeedCustomRepository.getAllLocalFeedByTypeAndKeyword(user, type, keyword);
    }

    @Override
    public LocalFeed getLocalFeedByFeedId(UUID feedId) {
        return localFeedMapper.localFeedEntityToDomain(
                localFeedRepository.findById(feedId)
                        .orElseThrow(() -> LocalFeedNotFoundException.EXCEPTION)
        );
    }
    
    @Override
    public LocalFeed getFeedById(UUID feedId) {
        return localFeedMapper.localFeedEntityToDomain(localFeedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION));
    }
}
