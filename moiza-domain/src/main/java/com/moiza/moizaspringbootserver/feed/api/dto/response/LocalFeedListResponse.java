package com.moiza.moizaspringbootserver.feed.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LocalFeedListResponse {
    private List<LocalFeedResponse> feedList;
}
