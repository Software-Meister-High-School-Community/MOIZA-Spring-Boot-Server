package com.moiza.moizaspringbootserver.like.spi;

import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.like.FeedLike;

public interface CommandFeedLikeSpi {
    void deleteFeedLike(FeedLike feedLike);
    void deleteAllLikesInFeed(Feed feed);
}
