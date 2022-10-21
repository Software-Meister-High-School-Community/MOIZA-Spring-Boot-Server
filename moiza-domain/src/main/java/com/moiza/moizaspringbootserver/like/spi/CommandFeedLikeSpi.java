package com.moiza.moizaspringbootserver.like.spi;

import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.like.FeedLike;

public interface CommandFeedLikeSpi {
    void saveFeedLike(FeedLike feedLike);
    void deleteAllFeedLikeByFeedId(Feed feedLike);
    void deleteFeedLike(Feed feedLike);
}
