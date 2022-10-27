package com.moiza.moizaspringbootserver.domain.report.mapper.feed;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedRepository;
import com.moiza.moizaspringbootserver.domain.report.domain.ReportEntity;
import com.moiza.moizaspringbootserver.domain.report.domain.ReportRepository;
import com.moiza.moizaspringbootserver.domain.report.domain.feed.FeedReportEntity;
import com.moiza.moizaspringbootserver.domain.report.domain.feed.FeedReportId;
import com.moiza.moizaspringbootserver.report.feed.FeedReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FeedReportMapperImpl implements FeedReportMapper {

    private final ReportRepository reportRepository;
    private final FeedRepository feedRepository;

    @Override
    public FeedReportEntity feedReportDomainToEntity(FeedReport feedReport) {
        return new FeedReportEntity(
                FeedReportId.builder()
                        .reportEntity(findByReportId(feedReport.getReportId()))
                        .feedEntity(findByFeedId(feedReport.getFeedId()))
                        .build()
        );
    }

    @Override
    public FeedReport feedReportEntityToDomain(FeedReportEntity feedReportEntity) {
        return FeedReport.builder()
                .reportId(feedReportEntity.getId().getReportEntity().getId())
                .feedId(feedReportEntity.getId().getFeedEntity().getId())
                .build();
    }

    private ReportEntity findByReportId(UUID id) {
        return reportRepository.findById(id).orElseThrow(RuntimeException::new); //TODO 담당자 Exception 만들어서 추가
    }

    private FeedEntity findByFeedId(UUID id) {
        return feedRepository.findById(id).orElseThrow(RuntimeException::new); //TODO 담당자 Exception 만들어서 추가
    }
}
