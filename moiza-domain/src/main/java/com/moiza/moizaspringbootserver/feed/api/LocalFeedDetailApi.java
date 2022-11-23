package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.response.LocalFeedDetailResponse;

import java.util.UUID;

public interface LocalFeedDetailApi {
    LocalFeedDetailResponse execute(UUID feedId);
}
