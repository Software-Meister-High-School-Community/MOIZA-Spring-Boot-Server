package com.moiza.moizaspringbootserver.report;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Report {

    private final UUID id;
    private final UUID reportedUserId;
}
