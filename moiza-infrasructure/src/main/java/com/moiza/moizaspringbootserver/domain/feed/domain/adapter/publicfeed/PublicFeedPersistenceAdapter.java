package com.moiza.moizaspringbootserver.domain.feed.domain.adapter.publicfeed;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.PublicFeedRepository;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom.PublicFeedRepositoryCustom;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class PublicFeedPersistenceAdapter implements PublicFeedSpi {

    private final FeedMapper feedMapper;
    private final PublicFeedRepository publicFeedRepository;
    private final PublicFeedRepositoryCustom publicFeedRepositoryCustom;

    @Override
    public void publicFeedDelete(Feed feed) {
        publicFeedRepository.deleteByFeed(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public PublishedFeedPage execute(UUID userId, String category, FeedType type, Orders order, int page) {
        return publicFeedRepositoryCustom.getPublicFeed(userId, category, type, order, page);
    }
}
