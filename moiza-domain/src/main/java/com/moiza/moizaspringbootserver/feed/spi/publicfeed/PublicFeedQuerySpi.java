package com.moiza.moizaspringbootserver.feed.spi.publicfeed;

import com.moiza.moizaspringbootserver.feed.spi.publicfeed.dto.response.QueryAllFeedsResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;

import java.util.UUID;

public interface PublicFeedQuerySpi {
    PublishedFeedPage getAllPublishedFeed(UUID userId, String category, FeedType type, QueryOrders order, int page);

    QueryAllFeedsResponse queryAllFeedsByNameAndCategory(String name, String category, FeedType type, Integer page);
}
