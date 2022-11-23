package com.moiza.moizaspringbootserver.feed.spi.publicfeed;

import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.PublicFeed;

public interface CommandPublicFeedSpi {
    void deletePublicFeedByFeedId(Feed feed);

    PublicFeed savePublicFeed(PublicFeed publicFeed);
}
