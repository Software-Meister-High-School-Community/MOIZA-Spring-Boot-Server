package com.moiza.moizaspringbootserver.domain.report.domain.comment.repository;

import com.moiza.moizaspringbootserver.domain.report.domain.comment.CommentReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentReportRepository extends CrudRepository<CommentReportEntity, UUID> {
}
