package com.moiza.moizaspringbootserver.domain.auth.mapper;

import com.moiza.moizaspringbootserver.auth.RefreshToken;
import com.moiza.moizaspringbootserver.domain.auth.domain.RefreshTokenEntity;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenMapperImpl implements RefreshTokenMapper {

    @Override
    public RefreshTokenEntity refreshTokenDomainToEntity(RefreshToken refreshToken) {
        return RefreshTokenEntity.builder()
                .email(refreshToken.getEmail())
                .refreshToken(refreshToken.getRefreshToken())
                .timeToLive(refreshToken.getTimeToLive())
                .build();
    }

    @Override
    public RefreshToken refreshTokenEntityToDomain(RefreshTokenEntity refreshTokenEntity) {
        return RefreshToken.builder()
                .email(refreshTokenEntity.getEmail())
                .refreshToken(refreshTokenEntity.getRefreshToken())
                .timeToLive(refreshTokenEntity.getTimeToLive())
                .build();
    }
}
