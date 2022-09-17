package com.moiza.moizaspringbootserver.domain.report.mapper;

import com.moiza.moizaspringbootserver.domain.report.domain.ReportEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.report.Report;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.util.UUID;

@RequiredArgsConstructor
@CommonsLog
public class ReportMapperImpl implements ReportMapper {

    private final UserRepository userRepository;

    @Override
    public ReportEntity reportDomainToEntity(Report report) {
        return ReportEntity.builder()
                .id(report.getId())
                .reportedUser(findReportId(report.getId()))
                .build();
    }

    @Override
    public Report reportEntityToDomain(ReportEntity reportEntity) {
        return Report.builder()
                .id(reportEntity.getId())
                .reportedUserId(reportEntity.getReportedUser().getId())
                .build();
    }

    private UserEntity findReportId(UUID id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
