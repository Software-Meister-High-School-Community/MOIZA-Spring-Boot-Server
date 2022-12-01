package com.moiza.moizaspringbootserver.feed.spi.publicfeed.dto.response;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class QueryAllFeedsResponse {
    private final Integer totalPage;
    private final List<Result> feedList;

    @Getter
    @Builder
    public static final class Result {
        private final UUID id;
        private final String title;
        private final FeedType type;
        private final LocalDateTime createdAt;
        private final Integer viewCount;
        private final Integer likeCount;
        private final Integer commentCount;
    }
}
