package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.localfeed;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.LocalFeedRepository;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.LocalFeedSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Adapter
public class LocalFeedPersistenceAdapter implements LocalFeedSpi {

    private final FeedMapper feedMapper;
    private final LocalFeedRepository localFeedRepository;

    @Override
    public void localFeedDelete(Feed feed) {
        localFeedRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public List<LocalFeed> getAllLocalFeedByTypeAndKeyword(User user, FeedType type, String keyword) {
        return null;
    }
}
