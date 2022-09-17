package com.moiza.moizaspringbootserver.domain.report.domain.feed.repository;

import com.moiza.moizaspringbootserver.domain.report.domain.feed.FeedReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedReportRepository extends CrudRepository<FeedReportEntity, UUID> {
}
