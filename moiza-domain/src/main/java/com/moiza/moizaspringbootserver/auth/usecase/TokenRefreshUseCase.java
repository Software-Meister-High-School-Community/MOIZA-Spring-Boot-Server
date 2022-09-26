package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.RefreshToken;
import com.moiza.moizaspringbootserver.auth.api.TokenRefreshApi;
import com.moiza.moizaspringbootserver.auth.api.dto.response.TokenRefreshResponse;
import com.moiza.moizaspringbootserver.auth.spi.CommandRefreshTokenSpi;
import com.moiza.moizaspringbootserver.auth.spi.QueryTokenRefreshSpi;
import com.moiza.moizaspringbootserver.user.spi.JwtSpi;
import com.moiza.moizaspringbootserver.user.spi.dto.response.SpiTokenResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class TokenRefreshUseCase implements TokenRefreshApi {

    private final QueryTokenRefreshSpi queryTokenRefreshSpi;
    private final CommandRefreshTokenSpi commandRefreshTokenSpi;
    private final JwtSpi jwtSpi;

    @Override
    public TokenRefreshResponse execute(String token) {
        RefreshToken refreshToken = queryTokenRefreshSpi.queryRefreshTokenByToken(token);
        SpiTokenResponse tokenResponse = jwtSpi.getToken(token);

        commandRefreshTokenSpi.saveRefreshToken(
                refreshToken.update(tokenResponse.getRefreshToken(), tokenResponse.getRefreshExp())
        );

        return new TokenRefreshResponse(
                tokenResponse.getAccessToken(),
                tokenResponse.getRefreshExp(),
                tokenResponse.getRefreshToken()
        );
    }
}
