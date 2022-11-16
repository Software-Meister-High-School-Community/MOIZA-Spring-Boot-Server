package com.moiza.moizaspringbootserver.feed.spi.dto.response;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class MyFeedListResponse {

    private final int totalPage;
    private final List<FeedResponse> feedList;

    @Getter
    @Builder
    public static class FeedResponse {
        private final UUID uuid;
        private final String title;
        private final FeedType type;
        private final LocalDateTime createdAt;
        private final Boolean isLike;
        private final Integer viewCount;
        private final Integer likeCount;
        private final Integer commentCount;
    }
}
