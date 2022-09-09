package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.PublicFeedEntity;
import com.moiza.moizaspringbootserver.feed.PublicFeed;

public interface PublicFeedMapper {
    PublicFeedEntity publicFeedDomainToEntity(PublicFeed publicFeed);
    PublicFeed publicFeedEntityToDomain(PublicFeedEntity publicFeedEntity);
}
