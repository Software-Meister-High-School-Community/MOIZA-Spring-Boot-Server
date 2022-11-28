package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.response.SearchAllFeedsResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;

public interface SearchAllFeedsApi {
    SearchAllFeedsResponse execute(String name, String category, FeedType type, QueryOrders order, Integer page);
}
