package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.LocalFeedEntity;
import com.moiza.moizaspringbootserver.feed.LocalFeed;
import org.springframework.stereotype.Component;

@Component
public class LocalFeedMapperImpl implements LocalFeedMapper {
    @Override
    public LocalFeed localFeedEntityToDomain(LocalFeedEntity localFeedEntity) {
        return LocalFeed.builder()
                .feedId(localFeedEntity.getId())
                .title(localFeedEntity.getTitle())
                .content(localFeedEntity.getContent())
                .createdAt(localFeedEntity.getCreatedAt())
                .build();
    }

    @Override
    public LocalFeedEntity localFeedDomainToEntity(LocalFeed localFeed) {
        return LocalFeedEntity.builder()
                .id(localFeed.getFeedId())
                .title(localFeed.getTitle())
                .content(localFeed.getContent())
                .build();
    }
}
