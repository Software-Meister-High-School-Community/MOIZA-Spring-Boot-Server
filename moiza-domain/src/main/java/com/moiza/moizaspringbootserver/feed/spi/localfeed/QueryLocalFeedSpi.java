package com.moiza.moizaspringbootserver.feed.spi.localfeed;

import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.user.domain.User;

import java.util.List;
import java.util.UUID;

public interface QueryLocalFeedSpi {
    List<LocalFeed> getAllLocalFeedByTypeAndKeyword(User user, FeedType type, String keyword);

    LocalFeed getLocalFeedByFeedId(UUID feedId);

}
