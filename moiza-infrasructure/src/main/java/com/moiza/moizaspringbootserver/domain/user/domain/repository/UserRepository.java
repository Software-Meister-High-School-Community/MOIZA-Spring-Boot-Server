package com.moiza.moizaspringbootserver.domain.user.domain.repository;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
	Optional<UserEntity> findByAccountId(String accountId);
	Optional<UserEntity> findByEmail(String email);
}
