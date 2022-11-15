package com.moiza.moizaspringbootserver.feed;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Feed {

    private final UUID id;
    private final FeedType feedType;
    private final UUID userId;
    private final UUID categoryId;

}
