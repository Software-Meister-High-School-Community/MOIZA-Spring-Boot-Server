package com.moiza.moizaspringbootserver.user.api;

import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserSignUpRequest;

public interface UserSignUpApi {
	void execute(DomainUserSignUpRequest domainUserSignUpRequest);
}
