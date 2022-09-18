package com.moiza.moizaspringbootserver.domain.auth.mapper;

import com.moiza.moizaspringbootserver.auth.EmailCode;
import com.moiza.moizaspringbootserver.domain.auth.domain.EmailCodeEntity;

public interface EmailCodeMapper {
    EmailCodeEntity emailCodeDomainToEntity(EmailCode emailCode);
    EmailCode emailCodeEntityToDomain(EmailCodeEntity emailCodeEntity);
}
