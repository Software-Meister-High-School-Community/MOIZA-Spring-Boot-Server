package com.moiza.moizaspringbootserver.feed.spi.feed;


import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;

import java.util.List;
import java.util.UUID;

public interface QueryFeedSpi {

    Feed getFeedById(UUID feedId);

    List<Feed> getMyFeedListByUserIdAndFeedTypeAndCategoryAndOrder(UUID userId, FeedType type, String category, QueryOrders order, int page);
}
