package com.moiza.moizaspringbootserver.feed.spi;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.PublishedFeedPage;

import java.util.UUID;

public interface PublishedFeedQuerySpi {
    enum Orders {
        LATEST, OLDEST, VIEW_COUNT, LIKE_COUNT
    }

    PublishedFeedPage execute(UUID userId, String category, FeedType type, Orders order, int page);
}
