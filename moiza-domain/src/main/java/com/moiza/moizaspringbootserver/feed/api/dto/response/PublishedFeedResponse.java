package com.moiza.moizaspringbootserver.feed.api.dto.response;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode
@Getter
@Builder
public class PublishedFeedResponse {
    private UUID id;
    private String title;
    private FeedType type;
    private String createdAt;
    private boolean isLiked;
    private int viewCount;
    private int likeCount;
    private int commentCount;
}
