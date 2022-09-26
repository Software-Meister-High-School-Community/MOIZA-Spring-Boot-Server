package com.moiza.moizaspringbootserver.auth.spi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {

	private final String accessToken;
	private final String refreshToken;
	private final Long refreshExp;
}
