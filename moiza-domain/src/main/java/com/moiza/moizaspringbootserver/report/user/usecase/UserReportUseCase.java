package com.moiza.moizaspringbootserver.report.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.report.Report;
import com.moiza.moizaspringbootserver.report.spi.CommandReportSpi;
import com.moiza.moizaspringbootserver.report.user.api.UserReportApi;
import com.moiza.moizaspringbootserver.report.user.domain.UserReport;
import com.moiza.moizaspringbootserver.report.user.spi.CommandUserReportSpi;
import com.moiza.moizaspringbootserver.report.user.spi.QueryUserReportSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UserReportUseCase implements UserReportApi {

    private final QueryUserSpi queryUserSpi;
    private final AuthSecuritySpi authSecuritySpi;
    private final QueryUserReportSpi queryUserReportSpi;
    private final CommandReportSpi commandReportSpi;
    private final CommandUserReportSpi commandUserReportSpi;

    @Override
    public void execute(UUID userId) {
        UUID id = authSecuritySpi.getCurrentUserId();
        User reportId = queryUserSpi.queryUserById(userId);

        UserReport userReport = queryUserReportSpi.getUserReport(id, reportId);

        Report report = Report.builder()
                .id(userId)
                .build();

        commandReportSpi.saveReport(report);
        commandUserReportSpi.saveUserReport(userReport);
    }
}
