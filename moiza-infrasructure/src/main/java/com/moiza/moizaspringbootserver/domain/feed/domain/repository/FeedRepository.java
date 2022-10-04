package com.moiza.moizaspringbootserver.domain.feed.domain.repository;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedRepository extends CrudRepository<FeedEntity, UUID> {
    Long countAllByUser(UserEntity user);
}
