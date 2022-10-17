package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.localfeed;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.LocalFeedRepository;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.LocalFeedSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class LocalFeedPersistenceAdapter implements LocalFeedSpi {

    private final FeedMapper feedMapper;
    private final LocalFeedRepository localFeedRepository;

    @Override
    public void deleteLocalFeed(Feed feed) {
        localFeedRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }
}
