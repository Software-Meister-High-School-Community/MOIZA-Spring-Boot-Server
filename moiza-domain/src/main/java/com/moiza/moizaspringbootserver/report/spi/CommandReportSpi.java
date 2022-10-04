package com.moiza.moizaspringbootserver.report.spi;

import com.moiza.moizaspringbootserver.report.Report;

public interface CommandReportSpi {
    void saveReport(Report report);
}
