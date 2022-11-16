package com.moiza.moizaspringbootserver.domain.report.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.report.domain.ReportRepository;
import com.moiza.moizaspringbootserver.domain.report.mapper.ReportMapper;
import com.moiza.moizaspringbootserver.report.Report;
import com.moiza.moizaspringbootserver.report.spi.CommandReportSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class ReportAdapter implements CommandReportSpi {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    public Report saveReport(Report report) {
        return reportMapper.reportEntityToDomain(
                reportRepository.save(
                        reportMapper.reportDomainToEntity(report)
                )
        );
    }
}
