package com.moiza.moizaspringbootserver.like.spi;

import java.util.UUID;

public interface FeedLikeQuerySpi {
    boolean existsByFeedIdAndUserId(UUID feedId, UUID userId);
}
