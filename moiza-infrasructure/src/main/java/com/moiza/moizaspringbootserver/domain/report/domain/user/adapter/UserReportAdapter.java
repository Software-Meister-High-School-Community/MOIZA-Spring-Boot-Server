package com.moiza.moizaspringbootserver.domain.report.domain.user.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.report.domain.user.repository.UserReportRepository;
import com.moiza.moizaspringbootserver.domain.report.mapper.user.UserReportMapper;
import com.moiza.moizaspringbootserver.report.user.domain.UserReport;
import com.moiza.moizaspringbootserver.report.user.spi.CommandUserReportSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class UserReportAdapter implements CommandUserReportSpi {

    private final UserReportRepository userReportRepository;
    private final UserReportMapper userReportMapper;

    @Override
    public void saveUserReport(UserReport userReport) {
        userReportRepository.save(
                userReportMapper.userReportDomainToEntity(userReport)
        );
    }

}

