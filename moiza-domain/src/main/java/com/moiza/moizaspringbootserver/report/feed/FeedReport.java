package com.moiza.moizaspringbootserver.report.feed;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class FeedReport {

    private final UUID reportId;
    private final UUID feedId;
}
