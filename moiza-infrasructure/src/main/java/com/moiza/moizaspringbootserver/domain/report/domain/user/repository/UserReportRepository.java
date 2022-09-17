package com.moiza.moizaspringbootserver.domain.report.domain.user.repository;

import com.moiza.moizaspringbootserver.domain.report.domain.user.UserReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserReportRepository extends CrudRepository<UserReportEntity, UUID> {
}
