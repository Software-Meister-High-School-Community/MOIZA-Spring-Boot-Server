package com.moiza.moizaspringbootserver.domain.auth.domain.repository;

import com.moiza.moizaspringbootserver.domain.auth.domain.RefreshTokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, String> {
    Optional<RefreshTokenEntity> findByRefreshToken(String token);
}
