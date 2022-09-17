package com.moiza.moizaspringbootserver.domain.report.mapper.user;

import com.moiza.moizaspringbootserver.domain.report.domain.user.UserReportEntity;
import com.moiza.moizaspringbootserver.report.user.UserReport;

public interface UserReportMapper {
    UserReportEntity feedReportDomainToEntity(UserReport userReport);
    UserReport feedReportEntityToDomain(UserReportEntity userReportEntity);
}
