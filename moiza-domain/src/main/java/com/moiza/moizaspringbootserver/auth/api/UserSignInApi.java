package com.moiza.moizaspringbootserver.auth.api;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainUserSignInRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.SignInResponse;

public interface UserSignInApi {
	SignInResponse execute(DomainUserSignInRequest domainUserSignInRequest);
}
