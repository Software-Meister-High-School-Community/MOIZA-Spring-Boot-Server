package com.moiza.moizaspringbootserver.feed.spi.feed;

import com.moiza.moizaspringbootserver.user.domain.User;

public interface QueryFeedCountSpi {
    Long getUserFeeCount(User user);
}
