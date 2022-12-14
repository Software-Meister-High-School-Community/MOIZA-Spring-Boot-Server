package com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;

import java.util.UUID;

public interface PublicFeedRepositoryCustom {
    PublishedFeedPage getPublicFeed(UUID userId, String category, FeedType type, QueryOrders order, int page);
}
