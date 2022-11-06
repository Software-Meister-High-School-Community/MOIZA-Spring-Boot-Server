package com.moiza.moizaspringbootserver.like.spi;

import com.moiza.moizaspringbootserver.like.FeedLike;
import java.util.UUID;

public interface FeedLikeQuerySpi {
    boolean existsByFeedIdAndUserId(UUID feedId, UUID userId);
    FeedLike getFeedLike(UUID feedId, UUID userId);
}
