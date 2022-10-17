package com.moiza.moizaspringbootserver.feed.spi.localfeed;

import com.moiza.moizaspringbootserver.feed.Feed;

public interface CommandLocalFeedSpi {
    void deleteLocalFeed(Feed feed);
}
