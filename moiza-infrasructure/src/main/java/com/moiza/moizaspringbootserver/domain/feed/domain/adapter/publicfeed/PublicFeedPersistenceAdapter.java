package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.publicfeed;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.PublicFeedRepository;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class PublicFeedPersistenceAdapter implements PublicFeedSpi {

    private final FeedMapper feedMapper;
    private final PublicFeedRepository publicFeedRepository;

    @Override
    public void publicFeedDelete(Feed feed) {
        publicFeedRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }
}
