package com.moiza.moizaspringbootserver.report.comment;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class CommentReport {

    private final UUID reportId;
    private final UUID commentId;
}
