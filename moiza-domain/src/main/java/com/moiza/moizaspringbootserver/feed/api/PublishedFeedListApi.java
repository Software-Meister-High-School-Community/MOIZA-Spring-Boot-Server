package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.response.PublishedFeedListResponse;

import java.util.UUID;

public interface PublishedFeedListApi {
    PublishedFeedListResponse execute(UUID userId, String category, String type, String order, int page);
}
