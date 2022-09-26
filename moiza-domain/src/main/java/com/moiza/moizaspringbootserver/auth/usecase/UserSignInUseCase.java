package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.RefreshToken;
import com.moiza.moizaspringbootserver.auth.api.UserSignInApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainUserSignInRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.SignInResponse;
import com.moiza.moizaspringbootserver.auth.exception.UserInvalidPasswordException;
import com.moiza.moizaspringbootserver.auth.spi.CommandRefreshTokenSpi;
import com.moiza.moizaspringbootserver.auth.spi.CommandUserDeviceTokenSpi;
import com.moiza.moizaspringbootserver.auth.spi.UserJwtSpi;
import com.moiza.moizaspringbootserver.auth.spi.UserSecuritySpi;
import com.moiza.moizaspringbootserver.auth.spi.dto.TokenResponse;
import com.moiza.moizaspringbootserver.user.User;
import com.moiza.moizaspringbootserver.user.UserDeviceToken;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UserSignInUseCase implements UserSignInApi {

	private final QueryUserSpi queryUserSpi;
	private final UserSecuritySpi userSecuritySpi;
	private final UserJwtSpi userJwtSpi;
	private final CommandUserDeviceTokenSpi commandUserDeviceTokenSpi;
	private final CommandRefreshTokenSpi commandRefreshTokenSpi;

	@Override
	public SignInResponse execute(DomainUserSignInRequest request) {

		User user = queryUserSpi.queryUserByAccountId(request.getAccountId());

		if (!userSecuritySpi.matches(request.getPassword(), user.getPassword())) {
			throw UserInvalidPasswordException.EXCEPTION;
		}

		UserDeviceToken userDeviceToken = UserDeviceToken.builder()
			.appDeviceToken(request.getAppDeviceToken())
			.webDeviceToken(request.getWebDeviceToken())
			.userId(user.getId())
			.build();

		commandUserDeviceTokenSpi.saveUserDeviceToken(userDeviceToken);

		TokenResponse tokenResponse = userJwtSpi.getToken(user.getEmail());

		commandRefreshTokenSpi.saveRefreshToken(
			RefreshToken.builder()
				.email(user.getEmail())
				.refreshToken(tokenResponse.getRefreshToken())
				.timeToLive(tokenResponse.getRefreshExp())
				.build()
		);

		return SignInResponse.builder()
			.accessToken(tokenResponse.getAccessToken())
			.refreshToken(tokenResponse.getRefreshToken())
			.expiredAt(LocalDateTime.now().plusSeconds(tokenResponse.getRefreshExp()))
			.build();
	}
}
