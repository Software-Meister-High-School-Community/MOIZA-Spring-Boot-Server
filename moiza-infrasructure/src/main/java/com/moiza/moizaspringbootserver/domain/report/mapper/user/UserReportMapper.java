package com.moiza.moizaspringbootserver.domain.report.mapper.user;

import com.moiza.moizaspringbootserver.domain.report.domain.user.UserReportEntity;
import com.moiza.moizaspringbootserver.report.user.domain.UserReport;

public interface UserReportMapper {
    UserReportEntity userReportDomainToEntity(UserReport userReport);
    UserReport userReportEntityToDomain(UserReportEntity userReportEntity);
}
