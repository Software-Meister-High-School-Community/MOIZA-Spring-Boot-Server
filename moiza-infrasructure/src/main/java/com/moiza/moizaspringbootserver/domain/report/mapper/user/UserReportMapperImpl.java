package com.moiza.moizaspringbootserver.domain.report.mapper.user;

import com.moiza.moizaspringbootserver.domain.report.domain.ReportEntity;
import com.moiza.moizaspringbootserver.domain.report.domain.ReportRepository;
import com.moiza.moizaspringbootserver.domain.report.domain.user.UserReportEntity;
import com.moiza.moizaspringbootserver.domain.report.domain.user.UserReportId;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.report.user.domain.UserReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserReportMapperImpl implements UserReportMapper {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    @Override
    public UserReportEntity userReportDomainToEntity(UserReport userReport) {
        return new UserReportEntity(
                UserReportId.builder()
                        .reportEntity(findByReportId(userReport.getReportId()))
                        .userEntity(findByUserId(userReport.getUserId()))
                        .build()
        );
    }

    @Override
    public UserReport userReportEntityToDomain(UserReportEntity userReportEntity) {
        return UserReport.builder()
                .reportId(userReportEntity.getId().getReportEntity().getId())
                .userId(userReportEntity.getId().getUserEntity().getId())
                .build();
    }

    private ReportEntity findByReportId(UUID id) {
        return reportRepository.findById(id).orElseThrow(RuntimeException::new); //TODO 담당자 Exception 만들어서 추가
    }

    private UserEntity findByUserId(UUID id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new); //TODO 담당자 Exception 만들어서 추가
    }
}
