package com.moiza.moizaspringbootserver.domain.auth.mapper;

import com.moiza.moizaspringbootserver.auth.EmailCode;
import com.moiza.moizaspringbootserver.domain.auth.domain.EmailCodeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailCodeMapperImpl implements EmailCodeMapper {

    @Override
    public EmailCodeEntity emailCodeDomainToEntity(EmailCode emailCode) {
        return EmailCodeEntity.builder()
                .email(emailCode.getEmail())
                .authCode(emailCode.getAuthCode())
                .type(emailCode.getType())
                .isVerify(emailCode.isVerify())
                .timeToLive(emailCode.getTimeToLIve())
                .build();
    }

    @Override
    public EmailCode emailCodeEntityToDomain(EmailCodeEntity emailCodeEntity) {
        return EmailCode.builder()
                .email(emailCodeEntity.getEmail())
                .authCode(emailCodeEntity.getAuthCode())
                .type(emailCodeEntity.getType())
                .isVerify(emailCodeEntity.isVerify())
                .timeToLIve(emailCodeEntity.getTimeToLive())
                .build();
    }
}
