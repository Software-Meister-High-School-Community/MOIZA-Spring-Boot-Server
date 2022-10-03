package com.moiza.moizaspringbootserver.domain.report.domain.user.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.report.domain.user.repository.UserReportRepository;
import com.moiza.moizaspringbootserver.domain.report.mapper.user.UserReportMapper;
import com.moiza.moizaspringbootserver.report.user.domain.UserReport;
import com.moiza.moizaspringbootserver.report.user.exception.UserReportNotFoundException;
import com.moiza.moizaspringbootserver.report.user.spi.QueryUserReportSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class QueryUserReportPersistenceAdapter implements QueryUserReportSpi {

    private final UserReportRepository userReportRepository;
    private final UserReportMapper userReportMapper;

    @Override
    public UserReport getUserReport(UUID userId, User reportId) {
        return userReportMapper.userReportEntityToDomain(
                userReportRepository.findById(reportId.getId())
                        .orElseThrow(() -> UserReportNotFoundException.EXCEPTION)
        );
    }
}
