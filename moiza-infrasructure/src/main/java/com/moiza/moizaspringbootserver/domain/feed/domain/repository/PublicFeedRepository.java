package com.moiza.moizaspringbootserver.domain.feed.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.PublicFeedEntity;
import com.moiza.moizaspringbootserver.feed.PublicFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Repository
public interface PublicFeedRepository extends JpaRepository<PublicFeedEntity, UUID> {

    void deleteByFeed(FeedEntity feed);
    List<PublicFeedEntity> findAllByFeedCategoryCategoryName(String category);
}
