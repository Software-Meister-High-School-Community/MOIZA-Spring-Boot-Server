package com.moiza.moizaspringbootserver.domain.report.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends CrudRepository<ReportEntity, UUID> {
}
