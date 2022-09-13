package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.PublicFeedEntity;
import com.moiza.moizaspringbootserver.feed.PublicFeed;
import org.springframework.stereotype.Component;

@Component
public class PublicFeedMapperImpl implements PublicFeedMapper {
    @Override
    public PublicFeedEntity publicFeedDomainToEntity(PublicFeed publicFeed) {
        return PublicFeedEntity.builder()
                .id(publicFeed.getFeedId())
                .title(publicFeed.getTitle())
                .content(publicFeed.getContent())
                .updatedAt(publicFeed.getUpdatedAt())
                .likeCount(publicFeed.getLikeCount())
                .viewCount(publicFeed.getViewCount())
                .build();
    }

    @Override
    public PublicFeed publicFeedEntityToDomain(PublicFeedEntity publicFeedEntity) {
        return PublicFeed.builder()
                .feedId(publicFeedEntity.getId())
                .title(publicFeedEntity.getTitle())
                .content(publicFeedEntity.getContent())
                .createdAt(publicFeedEntity.getCreatedAt().toLocalDateTime())
                .updatedAt(publicFeedEntity.getUpdatedAt())
                .likeCount(publicFeedEntity.getLikeCount())
                .viewCount(publicFeedEntity.getViewCount())
                .build();
    }
}
