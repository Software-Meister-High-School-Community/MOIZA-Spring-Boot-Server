package com.moiza.moizaspringbootserver.domain.feed.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.PublicFeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublicFeedRepository extends JpaRepository<PublicFeedEntity, UUID> {

    void deleteByFeed(FeedEntity feed);

    PublicFeedEntity findByFeedId(UUID feedId);

}
