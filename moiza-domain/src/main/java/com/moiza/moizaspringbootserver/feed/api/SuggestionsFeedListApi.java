package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.response.SuggestionsFeedListResponse;

public interface SuggestionsFeedListApi {
    SuggestionsFeedListResponse execute(String category);
}
