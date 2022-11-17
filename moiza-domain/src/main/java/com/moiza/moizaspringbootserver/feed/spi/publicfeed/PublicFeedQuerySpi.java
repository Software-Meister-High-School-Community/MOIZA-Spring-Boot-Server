package com.moiza.moizaspringbootserver.feed.spi.publicfeed;

import com.moiza.moizaspringbootserver.feed.PublicFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface PublicFeedQuerySpi {
    PublishedFeedPage getAllPublishedFeed(UUID userId, String category, FeedType type, QueryOrders order, int page);
    List<PublicFeed> getPublicFeedsByCategory(String category);
}
