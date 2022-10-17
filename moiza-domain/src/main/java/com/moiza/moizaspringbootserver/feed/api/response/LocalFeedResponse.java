package com.moiza.moizaspringbootserver.feed.api.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LocalFeedResponse {
    private String id;
    private String title;
    private String createdAt;
}
