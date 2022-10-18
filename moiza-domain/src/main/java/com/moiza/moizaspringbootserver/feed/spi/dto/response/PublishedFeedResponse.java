package com.moiza.moizaspringbootserver.feed.spi.dto.response;

import com.moiza.moizaspringbootserver.feed.PublicFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PublishedFeedResponse {
    private FeedType type;
    private Boolean liked;
    private Integer commentCount;
    private PublicFeed feed;
}
