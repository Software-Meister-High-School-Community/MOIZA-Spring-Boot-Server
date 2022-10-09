package com.moiza.moizaspringbootserver.feed.spi.dto.response;

import com.moiza.moizaspringbootserver.feed.PublicFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CombinedFeed {
    private FeedType type;
    private boolean liked;
    private int commentCount;
    private PublicFeed feed;
}
