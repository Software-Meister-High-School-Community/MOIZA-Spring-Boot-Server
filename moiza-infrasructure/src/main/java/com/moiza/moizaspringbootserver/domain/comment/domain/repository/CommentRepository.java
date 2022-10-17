package com.moiza.moizaspringbootserver.domain.comment.domain.repository;

import com.moiza.moizaspringbootserver.domain.comment.domain.CommentEntity;
import java.util.UUID;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.feed.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, UUID> {

    void deleteByFeedEntity(FeedEntity feed);
}
