package com.moiza.moizaspringbootserver.user.api.dto.request;

import com.moiza.moizaspringbootserver.user.domain.enums.School;
import com.moiza.moizaspringbootserver.user.domain.enums.Sex;
import com.moiza.moizaspringbootserver.user.domain.enums.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainUserSignUpRequest {
	private final String accountId;
	private final String password;
	private final String email;
	private final String name;
	private final String birthDay;
	private final Sex sex;
	private final UserType userType;
	private final School school;
}
