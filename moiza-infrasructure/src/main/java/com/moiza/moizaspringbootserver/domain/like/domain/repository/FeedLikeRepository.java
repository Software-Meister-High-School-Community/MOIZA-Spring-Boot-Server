package com.moiza.moizaspringbootserver.domain.like.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.like.domain.FeedLikeEntity;
import com.moiza.moizaspringbootserver.domain.like.domain.FeedLikeId;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedLikeRepository extends CrudRepository<FeedLikeEntity, FeedLikeId> {

    void deleteByFeed(FeedEntity feed);
    void findByUserAndFeed(UserEntity user, FeedEntity feed);
}
