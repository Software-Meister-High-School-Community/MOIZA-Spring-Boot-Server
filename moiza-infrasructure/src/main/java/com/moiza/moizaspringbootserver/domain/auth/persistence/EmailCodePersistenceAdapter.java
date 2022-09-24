package com.moiza.moizaspringbootserver.domain.auth.persistence;

import com.moiza.moizaspringbootserver.auth.EmailCode;
import com.moiza.moizaspringbootserver.auth.exception.EmailCodeNotfoundException;
import com.moiza.moizaspringbootserver.auth.spi.EmailCodePort;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.auth.domain.repository.EmailCodeRepository;
import com.moiza.moizaspringbootserver.domain.auth.mapper.EmailCodeMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class EmailCodePersistenceAdapter implements EmailCodePort {

	private final EmailCodeRepository emailCodeRepository;
	private final EmailCodeMapper emailCodeMapper;

	@Override
	public EmailCode queryEmailCodeById(String email) {
		return emailCodeMapper.emailCodeEntityToDomain(
			emailCodeRepository.findById(email)
			.orElseThrow(() -> EmailCodeNotfoundException.EXCEPTION)
		);
	}
}
