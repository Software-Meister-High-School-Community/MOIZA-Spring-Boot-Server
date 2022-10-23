package com.moiza.moizaspringbootserver.domain.follow.domain.repository;

import com.moiza.moizaspringbootserver.domain.follow.domain.FollowEntity;
import com.moiza.moizaspringbootserver.domain.follow.domain.FollowId;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowRepository extends CrudRepository<FollowEntity, FollowId> {

    Long countAllByUserEntity(UserEntity user);
    Optional<FollowEntity> findByUserEntityIdAndTargetUserId(UUID userId, UUID targetUserId);
}
