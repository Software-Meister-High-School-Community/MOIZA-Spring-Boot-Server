package com.moiza.moizaspringbootserver.feed.spi.publicfeed;

import com.moiza.moizaspringbootserver.feed.Feed;

public interface CommandPublicFeedSpi {
    void deletePublicFeedbyFeedId(Feed feed);
}
