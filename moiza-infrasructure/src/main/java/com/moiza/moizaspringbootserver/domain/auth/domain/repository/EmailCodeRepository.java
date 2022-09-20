package com.moiza.moizaspringbootserver.domain.auth.domain.repository;

import com.moiza.moizaspringbootserver.domain.auth.domain.EmailCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailCodeRepository extends CrudRepository<EmailCodeEntity, String> {
}
