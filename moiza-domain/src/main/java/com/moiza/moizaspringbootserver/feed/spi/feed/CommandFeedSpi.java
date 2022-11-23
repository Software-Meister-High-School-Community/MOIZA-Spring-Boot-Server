package com.moiza.moizaspringbootserver.feed.spi.feed;

import com.moiza.moizaspringbootserver.feed.Feed;

public interface CommandFeedSpi {

    void deleteFeedByFeedId(Feed feed);
    
    Feed getFeedById(UUID feedId);

    Feed saveFeed(Feed feed);
}
