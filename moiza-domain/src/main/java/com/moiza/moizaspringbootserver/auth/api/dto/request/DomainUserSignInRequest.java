package com.moiza.moizaspringbootserver.auth.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainUserSignInRequest {

	private final String accountId;
	private final String password;
	private final String appDeviceToken;
	private final String webDeviceToken;
}
