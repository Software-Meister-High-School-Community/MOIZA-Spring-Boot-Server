package com.moiza.moizaspringbootserver.feed.spi.feed;

import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.user.domain.User;

import java.util.UUID;

public interface QueryFeedSpi {
    Long getUserFeeCount(User user);

    Feed getFeedById(UUID feedId);
    String getCategoryNameByFeedId(UUID feedId);

    Boolean compareFeedUserId(UUID feedId, UUID userId);
}
