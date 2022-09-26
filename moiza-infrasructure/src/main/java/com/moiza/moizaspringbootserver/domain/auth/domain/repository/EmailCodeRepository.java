package com.moiza.moizaspringbootserver.domain.auth.domain.repository;

import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import com.moiza.moizaspringbootserver.domain.auth.domain.EmailCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailCodeRepository extends CrudRepository<EmailCodeEntity, String> {
    Optional<EmailCodeEntity> findByEmailAndType(String email, Type type);
}
