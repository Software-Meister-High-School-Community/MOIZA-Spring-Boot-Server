package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.response.LocalFeedListResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;

public interface LocalFeedListApi {
    LocalFeedListResponse execute(FeedType feedType, String category);
}
