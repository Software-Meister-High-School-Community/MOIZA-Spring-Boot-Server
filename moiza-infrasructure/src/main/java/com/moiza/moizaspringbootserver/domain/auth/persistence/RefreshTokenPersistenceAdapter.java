package com.moiza.moizaspringbootserver.domain.auth.persistence;

import com.moiza.moizaspringbootserver.auth.domain.RefreshToken;
import com.moiza.moizaspringbootserver.auth.exception.RefreshTokenNotFoundException;
import com.moiza.moizaspringbootserver.auth.spi.TokenRefreshSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.auth.domain.repository.RefreshTokenRepository;
import com.moiza.moizaspringbootserver.domain.auth.mapper.RefreshTokenMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class RefreshTokenPersistenceAdapter implements TokenRefreshSpi {

    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshTokenMapper refreshTokenMapper;

    @Override
    public RefreshToken queryRefreshTokenByToken(String token) {
        return refreshTokenMapper
                .refreshTokenEntityToDomain(refreshTokenRepository.findByRefreshToken(token)
                        .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION));
    }

    @Override
    public void saveRefreshToken(com.moiza.moizaspringbootserver.auth.domain.RefreshToken refreshToken) {
        refreshTokenRepository.save(
                refreshTokenMapper.refreshTokenDomainToEntity(refreshToken)
        );
    }
}
