package com.moiza.moizaspringbootserver.domain.report.presentatoin;

import com.moiza.moizaspringbootserver.report.user.api.UserReportApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/report")
@RestController
public class ReportWebAdapter {
    private final UserReportApi userReportApi;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{user-id}/reports")
    public void userReport(@PathVariable("user-id")UUID userId) {
        userReportApi.execute(userId);
    }
}
