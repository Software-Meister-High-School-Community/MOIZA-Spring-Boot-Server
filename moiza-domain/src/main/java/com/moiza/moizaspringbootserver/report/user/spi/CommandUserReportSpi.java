package com.moiza.moizaspringbootserver.report.user.spi;

import com.moiza.moizaspringbootserver.report.user.domain.UserReport;

public interface CommandUserReportSpi {
    void saveUserReport(UserReport userReport);

}
