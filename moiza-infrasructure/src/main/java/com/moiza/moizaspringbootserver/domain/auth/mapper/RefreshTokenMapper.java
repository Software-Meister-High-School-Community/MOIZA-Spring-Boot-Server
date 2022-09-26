package com.moiza.moizaspringbootserver.domain.auth.mapper;

import com.moiza.moizaspringbootserver.auth.domain.RefreshToken;
import com.moiza.moizaspringbootserver.domain.auth.domain.RefreshTokenEntity;

public interface RefreshTokenMapper {
    RefreshTokenEntity refreshTokenDomainToEntity(RefreshToken refreshToken);
    RefreshToken refreshTokenEntityToDomain(RefreshTokenEntity refreshTokenEntity);
}
