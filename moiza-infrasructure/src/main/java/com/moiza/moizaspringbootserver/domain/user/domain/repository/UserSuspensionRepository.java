package com.moiza.moizaspringbootserver.domain.user.domain.repository;

import com.moiza.moizaspringbootserver.domain.user.domain.UserSuspensionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserSuspensionRepository extends CrudRepository<UserSuspensionEntity, UUID> {
}
