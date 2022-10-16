package com.moiza.moizaspringbootserver.feed.spi.feed;

import com.moiza.moizaspringbootserver.user.domain.User;

public interface QueryFeedCountSqi {
    Long getUserFeeCount(User user);
}
