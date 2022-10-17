package com.moiza.moizaspringbootserver.like.spi;

import com.moiza.moizaspringbootserver.feed.Feed;

public interface CommandFeedLikeSpi {
    void deleteAllFeedLike(Feed feed);

}
