package com.moiza.moizaspringbootserver.domain.user.persistence;

import com.moiza.moizaspringbootserver.auth.RefreshToken;
import com.moiza.moizaspringbootserver.auth.spi.RefreshTokenSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.auth.domain.repository.RefreshTokenRepository;
import com.moiza.moizaspringbootserver.domain.auth.mapper.RefreshTokenMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class RefreshTokenPersistenceAdapter implements RefreshTokenSpi {

	private final RefreshTokenRepository refreshTokenRepository;
	private final RefreshTokenMapper refreshTokenMapper;

	@Override
	public void saveRefreshToken(RefreshToken refreshToken) {
		refreshTokenRepository.save(
			refreshTokenMapper.refreshTokenDomainToEntity(refreshToken)
		);
	}
}
