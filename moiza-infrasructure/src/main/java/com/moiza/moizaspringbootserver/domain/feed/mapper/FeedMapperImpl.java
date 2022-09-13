package com.moiza.moizaspringbootserver.domain.feed.mapper;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.feed.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedMapperImpl implements FeedMapper {

    @Override
    public FeedEntity feedDomainToEntity(Feed feed) {
        return FeedEntity.builder()
                .id(feed.getId())
                .feedType(feed.getFeedType())
                .build();
    }

    @Override
    public Feed feedEntityToDomain(FeedEntity feedEntity) {
        return Feed.builder()
                .id(feedEntity.getId())
                .feedType(feedEntity.getFeedType())
                .build();
    }
}
