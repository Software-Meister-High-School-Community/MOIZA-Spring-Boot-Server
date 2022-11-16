package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.MyFeedListResponse;

public interface QueryMyFeedListApi {
    MyFeedListResponse execute(String category, FeedType type, String order, int page);
}
