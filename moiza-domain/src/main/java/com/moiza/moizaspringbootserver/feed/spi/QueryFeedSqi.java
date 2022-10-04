package com.moiza.moizaspringbootserver.feed.spi;

import com.moiza.moizaspringbootserver.user.domain.User;

public interface QueryFeedSqi {
    Long getUserFeeCount(User user);
}
