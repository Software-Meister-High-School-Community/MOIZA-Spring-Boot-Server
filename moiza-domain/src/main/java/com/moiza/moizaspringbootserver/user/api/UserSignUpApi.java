package com.moiza.moizaspringbootserver.user.api;

import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserSignUpApiRequest;

public interface UserSignUpApi {
	void execute(DomainUserSignUpApiRequest domainUserSignUpApiRequest);
}
