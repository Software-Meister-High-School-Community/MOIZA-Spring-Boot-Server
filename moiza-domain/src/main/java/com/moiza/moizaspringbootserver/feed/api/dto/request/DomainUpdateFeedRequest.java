package com.moiza.moizaspringbootserver.feed.api.dto.request;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class DomainUpdateFeedRequest {

    private final String title;
    private final String content;
    private final FeedType feedType;
    private final List<String> imageUrls;
}
