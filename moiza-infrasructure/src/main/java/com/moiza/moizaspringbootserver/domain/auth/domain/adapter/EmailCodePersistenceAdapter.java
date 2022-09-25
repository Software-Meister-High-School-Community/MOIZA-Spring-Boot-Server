package com.moiza.moizaspringbootserver.domain.auth.domain.adapter;

import com.moiza.moizaspringbootserver.auth.domain.EmailCode;
import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import com.moiza.moizaspringbootserver.auth.exception.EmailCodeNotFoundException;
import com.moiza.moizaspringbootserver.auth.spi.EmailCodeSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.auth.domain.EmailCodeEntity;
import com.moiza.moizaspringbootserver.domain.auth.domain.repository.EmailCodeRepository;
import com.moiza.moizaspringbootserver.domain.auth.mapper.EmailCodeMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class EmailCodePersistenceAdapter implements EmailCodeSpi {

    private final EmailCodeRepository emailCodeRepository;
    private final EmailCodeMapper emailCodeMapper;

    @Override
    public EmailCode queryEmailCodeByEmailAndType(String email, Type type) {
        EmailCodeEntity emailCodeEntity = emailCodeRepository.findByEmailAndType(email, type)
                .orElseThrow(() -> EmailCodeNotFoundException.EXCEPTION);

        return emailCodeMapper.emailCodeEntityToDomain(emailCodeEntity);
    }

    @Override
    public void saveAuthCode(EmailCode emailCode) {
        emailCodeRepository.save(
                emailCodeMapper.emailCodeDomainToEntity(emailCode)
        );
    }
}
