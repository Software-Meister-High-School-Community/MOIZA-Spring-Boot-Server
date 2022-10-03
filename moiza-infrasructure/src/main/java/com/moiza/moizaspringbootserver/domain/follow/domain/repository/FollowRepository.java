package com.moiza.moizaspringbootserver.domain.follow.domain.repository;

import com.moiza.moizaspringbootserver.domain.follow.domain.FollowEntity;
import com.moiza.moizaspringbootserver.domain.follow.domain.FollowId;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowRepository extends CrudRepository<FollowEntity, FollowId> {

    Optional<FollowEntity> findByFollowIdAndTargetUser(UserEntity user, UserEntity targetUser);

    Long countAllByUserEntity(UserEntity user);
}
