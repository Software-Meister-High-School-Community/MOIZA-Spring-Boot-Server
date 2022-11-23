package com.moiza.moizaspringbootserver.report.spi;

import com.moiza.moizaspringbootserver.report.Report;

public interface CommandReportSpi {
    Report saveReport(Report report);
}
