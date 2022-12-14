package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.api.TokenRefreshApi;
import com.moiza.moizaspringbootserver.auth.api.dto.response.TokenRefreshResponse;
import com.moiza.moizaspringbootserver.auth.domain.RefreshToken;
import com.moiza.moizaspringbootserver.auth.spi.CommandRefreshTokenSpi;
import com.moiza.moizaspringbootserver.auth.spi.QueryTokenRefreshSpi;
import com.moiza.moizaspringbootserver.user.spi.UserJwtSpi;
import com.moiza.moizaspringbootserver.user.spi.dto.response.SpiTokenResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class TokenRefreshUseCase implements TokenRefreshApi {

    private final QueryTokenRefreshSpi queryTokenRefreshSpi;
    private final CommandRefreshTokenSpi commandRefreshTokenSpi;
    private final UserJwtSpi userJwtSpi;

    @Override
    public TokenRefreshResponse execute(String token) {
        RefreshToken refreshToken = queryTokenRefreshSpi.queryRefreshTokenByToken(token);
        SpiTokenResponse tokenResponse = userJwtSpi.getToken(token);

        commandRefreshTokenSpi.saveRefreshToken(
                refreshToken.update(tokenResponse.getRefreshToken(), tokenResponse.getRefreshExp())
        );

        return TokenRefreshResponse.builder()
                .accessToken(refreshToken.getRefreshToken())
                .expiredAt(refreshToken.getTimeToLive())
                .refreshToken(refreshToken.getRefreshToken())
                .build();

    }
}
