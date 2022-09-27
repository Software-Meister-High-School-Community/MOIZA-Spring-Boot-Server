package com.moiza.moizaspringbootserver.domain.report.domain.comment;

import com.moiza.moizaspringbootserver.domain.comment.domain.CommentEntity;
import com.moiza.moizaspringbootserver.domain.report.domain.ReportEntity;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class CommentReportId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private ReportEntity reportEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private CommentEntity commentEntity;

    @Builder
    public CommentReportId(ReportEntity reportEntity, CommentEntity commentEntity) {
        this.reportEntity = reportEntity;
        this.commentEntity = commentEntity;
    }
}
