package com.moiza.moizaspringbootserver.domain.feed.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedCategoryEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.FeedCategoryId;
import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedCategoryRepository extends CrudRepository<FeedCategoryEntity, FeedCategoryId> {

    void deleteByFeed(FeedEntity feed);
}
