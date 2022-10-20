package com.moiza.moizaspringbootserver.like.spi;

import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.like.FeedLike;

public interface CommandFeedLikeSpi {
    void deleteAllFeedLikeByFeedId(Feed feed);
    void saveFeedLike(FeedLike feedLike);
}
