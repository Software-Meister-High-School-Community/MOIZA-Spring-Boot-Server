package com.moiza.moizaspringbootserver.domain.like.mapper;

import com.moiza.moizaspringbootserver.domain.like.domain.FeedLikeEntity;
import com.moiza.moizaspringbootserver.like.FeedLike;

public interface FeedLikeMapper {
    FeedLike feedLikeEntityToDomain(FeedLikeEntity feedLikeEntity);
    FeedLikeEntity feedLikeDomainToEntity(FeedLike feedLike);
}
