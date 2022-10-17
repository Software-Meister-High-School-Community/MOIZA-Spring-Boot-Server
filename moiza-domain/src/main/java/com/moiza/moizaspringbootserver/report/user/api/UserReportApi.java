package com.moiza.moizaspringbootserver.report.user.api;

import java.util.UUID;

public interface UserReportApi {
    void execute(UUID userId);
}
