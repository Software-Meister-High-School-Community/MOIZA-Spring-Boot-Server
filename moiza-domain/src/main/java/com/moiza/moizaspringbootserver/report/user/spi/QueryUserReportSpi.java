package com.moiza.moizaspringbootserver.report.user.spi;

import com.moiza.moizaspringbootserver.report.user.domain.UserReport;
import com.moiza.moizaspringbootserver.user.domain.User;

import java.util.UUID;

public interface QueryUserReportSpi {
    UserReport getUserReport(UUID userId, User reportId);
}
