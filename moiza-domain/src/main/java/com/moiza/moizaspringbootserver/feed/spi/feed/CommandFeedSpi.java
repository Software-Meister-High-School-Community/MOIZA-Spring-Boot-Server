package com.moiza.moizaspringbootserver.feed.spi.feed;

import com.moiza.moizaspringbootserver.feed.Feed;

import java.util.UUID;

public interface CommandFeedSpi {

    void deleteFeedbyFeedId(Feed feed);

    Feed getFeedById(UUID feedId);
}
