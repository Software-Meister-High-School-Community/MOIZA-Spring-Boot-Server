package com.moiza.moizaspringbootserver.domain.report.mapper;

import com.moiza.moizaspringbootserver.domain.report.domain.ReportEntity;
import com.moiza.moizaspringbootserver.report.Report;

public interface ReportMapper {
    ReportEntity reportDomainToEntity(Report report);
    Report reportEntityToDomain(ReportEntity reportEntity);
}
