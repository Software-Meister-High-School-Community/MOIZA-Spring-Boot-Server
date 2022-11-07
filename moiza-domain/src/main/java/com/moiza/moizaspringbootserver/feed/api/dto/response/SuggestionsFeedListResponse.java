package com.moiza.moizaspringbootserver.feed.api.dto.response;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class SuggestionsFeedListResponse {

    private final List<SuggestionsFeed> feedList;

    @Getter
    @Builder
    public static final class SuggestionsFeed {
        private final UUID id;
        private final String title;
        private final FeedType type;
        private final LocalDateTime createdAt;
        private final String authorName;
    }
}
