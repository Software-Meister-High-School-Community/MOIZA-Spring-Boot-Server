package com.moiza.moizaspringbootserver.domain.report.mapper.feed;

import com.moiza.moizaspringbootserver.domain.report.domain.feed.FeedReportEntity;
import com.moiza.moizaspringbootserver.report.feed.FeedReport;

public interface FeedReportMapper {
    FeedReportEntity feedReportDomainToEntity(FeedReport feedReport);
    FeedReport feedReportEntityToDomain(FeedReportEntity feedReportEntity);
}
