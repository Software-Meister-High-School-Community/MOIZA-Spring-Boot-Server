package com.moiza.moizaspringbootserver.report.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.report.Report;
import com.moiza.moizaspringbootserver.report.feed.FeedReport;
import com.moiza.moizaspringbootserver.report.feed.api.FeedReportApi;
import com.moiza.moizaspringbootserver.report.feed.spi.CommandFeedReportSpi;
import com.moiza.moizaspringbootserver.report.spi.CommandReportSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class FeedReportUseCase implements FeedReportApi {

    private final AuthSecuritySpi authSecuritySpi;

    private final CommandReportSpi commandReportSpi;

    private final CommandFeedReportSpi commandFeedReportSpi;

    @Override
    public void execute(UUID feedId) {
        //TODO 게시글 신고 머지되면 feed 있는지 검증
        UUID id = authSecuritySpi.getCurrentUserId();

        Report report = commandReportSpi.saveReport(Report.builder()
                .reportedUserId(id)
                .build()
        );
        FeedReport feedReport = FeedReport.builder()
                .reportId(report.getId())
                .feedId(feedId)
                .build();
        commandFeedReportSpi.saveFeedReport(feedReport);
    }
}
