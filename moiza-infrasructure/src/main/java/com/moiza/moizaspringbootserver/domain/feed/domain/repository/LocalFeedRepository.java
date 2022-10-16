package com.moiza.moizaspringbootserver.domain.feed.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.LocalFeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalFeedRepository extends JpaRepository<LocalFeedEntity, UUID> {

    void deleteByFeed(FeedEntity feed);
}
