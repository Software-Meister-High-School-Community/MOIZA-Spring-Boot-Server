package com.moiza.moizaspringbootserver.domain.user.domain.repository;

import com.moiza.moizaspringbootserver.domain.user.domain.GraduateVerifyingFileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GraduateVerifyingFileRepository extends CrudRepository<GraduateVerifyingFileEntity, UUID> {
}
