package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.LocalFeedEntity;
import com.moiza.moizaspringbootserver.feed.LocalFeed;

public interface LocalFeedMapper {
    LocalFeedEntity localFeedDomainToEntity(LocalFeed localFeed);
    LocalFeed localFeedEntityToDomain(LocalFeedEntity localFeedEntity);
}
