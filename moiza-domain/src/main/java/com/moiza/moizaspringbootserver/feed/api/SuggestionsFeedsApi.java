package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.response.SuggestionsFeedsResponse;

public interface SuggestionsFeedsApi {
    SuggestionsFeedsResponse execute(String category, Integer size);
}
