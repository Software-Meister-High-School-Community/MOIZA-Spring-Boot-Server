package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.feed.Feed;

public interface FeedMapper {
    FeedEntity feedDomainToEntity(Feed feed);
    Feed feedEntityToDomain(FeedEntity feedEntity);
}
