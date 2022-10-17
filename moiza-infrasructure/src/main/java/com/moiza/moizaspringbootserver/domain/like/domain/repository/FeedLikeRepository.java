package com.moiza.moizaspringbootserver.domain.like.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.like.domain.FeedLikeEntity;
import com.moiza.moizaspringbootserver.domain.like.domain.FeedLikeId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedLikeRepository extends CrudRepository<FeedLikeEntity, FeedLikeId> {

    void deleteAllByFeed(FeedEntity feed);
}
