package com.moiza.moizaspringbootserver.domain.user.domain.repository;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.custom.UserRepositoryCustom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID>, UserRepositoryCustom {
    Optional<UserEntity> findByAccountId(String accountId);
    Optional<UserEntity> findByEmail(String email);
}
