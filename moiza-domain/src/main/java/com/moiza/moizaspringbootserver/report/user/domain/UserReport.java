package com.moiza.moizaspringbootserver.report.user.domain;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class UserReport {

    private final UUID reportId;
    private final UUID userId;
}
