package com.moiza.moizaspringbootserver.report.feed.spi;

import com.moiza.moizaspringbootserver.report.feed.FeedReport;

public interface CommandFeedReportSpi {

    FeedReport saveFeedReport(FeedReport feedReport);
}
