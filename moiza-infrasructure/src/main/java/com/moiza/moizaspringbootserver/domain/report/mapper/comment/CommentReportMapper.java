package com.moiza.moizaspringbootserver.domain.report.mapper.comment;

import com.moiza.moizaspringbootserver.domain.report.domain.comment.CommentReportEntity;
import com.moiza.moizaspringbootserver.report.comment.CommentReport;

public interface CommentReportMapper {
    CommentReportEntity commentReportDomainToEntity(CommentReport commentReport);
    CommentReport commentReportEntityToDomain(CommentReportEntity commentReportEntity);
}
