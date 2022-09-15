package com.moiza.moizaspringbootserver.domain.report.mapper.comment;

import com.moiza.moizaspringbootserver.domain.comment.CommentEntity;
import com.moiza.moizaspringbootserver.domain.comment.repository.CommentRepository;
import com.moiza.moizaspringbootserver.domain.report.domain.ReportEntity;
import com.moiza.moizaspringbootserver.domain.report.domain.ReportRepository;
import com.moiza.moizaspringbootserver.domain.report.domain.comment.CommentReportEntity;
import com.moiza.moizaspringbootserver.domain.report.domain.comment.CommentReportId;
import com.moiza.moizaspringbootserver.report.comment.CommentReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CommentReportMapperImpl implements CommentReportMapper {

    private final ReportRepository reportRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentReportEntity commentReportDomainToEntity(CommentReport commentReport) {
        return new CommentReportEntity(
                CommentReportId.builder()
                        .reportEntity(findByReportId(commentReport.getReportId()))
                        .commentEntity(findByCommentId(commentReport.getCommentId()))
                        .build()
        );
    }

    @Override
    public CommentReport commentReportEntityToDomain(CommentReportEntity commentReportEntity) {
        return CommentReport.builder()
                .reportId(commentReportEntity.getId().getReportEntity().getId())
                .commentId(commentReportEntity.getId().getCommentEntity().getId())
                .build();
    }

    private ReportEntity findByReportId(UUID id) {
        return reportRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    private CommentEntity findByCommentId(UUID id) {
        return commentRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
