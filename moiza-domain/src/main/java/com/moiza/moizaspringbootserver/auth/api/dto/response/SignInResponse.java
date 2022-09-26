package com.moiza.moizaspringbootserver.auth.api.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResponse {

	private final String accessToken;

	private final LocalDateTime expiredAt;

	private final String refreshToken;

}
