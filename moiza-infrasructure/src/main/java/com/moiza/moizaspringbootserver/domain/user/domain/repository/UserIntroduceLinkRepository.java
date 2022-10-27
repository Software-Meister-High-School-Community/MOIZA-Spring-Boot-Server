package com.moiza.moizaspringbootserver.domain.user.domain.repository;

import com.moiza.moizaspringbootserver.domain.user.domain.UserIntroduceLinkEntity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIntroduceLinkRepository extends CrudRepository<UserIntroduceLinkEntity, UUID> {
    List<UserIntroduceLinkEntity> findAllByUserEntityId(UUID userId);
}
