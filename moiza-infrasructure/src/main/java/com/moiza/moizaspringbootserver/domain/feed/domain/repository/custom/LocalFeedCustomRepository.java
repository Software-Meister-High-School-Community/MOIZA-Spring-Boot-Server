package com.moiza.moizaspringbootserver.domain.feed.domain.repository.custom;

import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.user.domain.User;

import java.util.List;

public interface LocalFeedCustomRepository {
    List<LocalFeed> getAllLocalFeedByTypeAndKeyword(User user, FeedType type, String keyword);
}
