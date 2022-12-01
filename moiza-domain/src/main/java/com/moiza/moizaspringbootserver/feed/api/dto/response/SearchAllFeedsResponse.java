package com.moiza.moizaspringbootserver.feed.api.dto.response;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class SearchAllFeedsResponse {
    private final Integer totalPage;
    private final List<SearchResult> feedList;

    @Getter
    @Builder
    public static final class SearchResult {
        private final UUID id;
        private final String title;
        private final FeedType type;
        private final LocalDateTime createdAt;
        private final Boolean isLike;
        private final Integer viewCount;
        private final Integer likeCount;
        private final Integer commentCount;
    }
}
