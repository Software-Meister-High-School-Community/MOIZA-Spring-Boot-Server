package com.moiza.moizaspringbootserver.report.feed.api;

import java.util.UUID;

public interface FeedReportApi {

    void execute(UUID feedId);
}
