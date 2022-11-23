package com.moiza.moizaspringbootserver.domain.report.presentatoin;

import com.moiza.moizaspringbootserver.report.feed.api.FeedReportApi;
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

    private final FeedReportApi feedReportApi;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{user-id}/reports")
    public void userReport(@PathVariable("user-id") UUID userId) {
        userReportApi.execute(userId);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}/reports")
    public void feedReport(@PathVariable("feed-id") UUID feedId) {
        feedReportApi.execute(feedId);
    }
}
