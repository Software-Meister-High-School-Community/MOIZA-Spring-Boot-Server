package com.moiza.moizaspringbootserver.feed.api.dto.response;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LocalFeedDetailResponse {
    private String title;
    private String content;
    private FeedType feedType;
    private String category;
}
