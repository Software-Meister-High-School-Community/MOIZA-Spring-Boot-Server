package com.moiza.moizaspringbootserver.domain.user.presentation;


import com.moiza.moizaspringbootserver.domain.user.presentation.dto.request.WebUserSignUpRequest;
import com.moiza.moizaspringbootserver.user.api.UserSignUpApi;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserWebAdapter {

	private final UserSignUpApi userSignUpApi;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void userSignUp(@RequestBody WebUserSignUpRequest request) {
		userSignUpApi.execute(
			DomainUserSignUpRequest.builder()
				.accountId(request.getAccountId())
				.password(request.getPassword())
				.email(request.getEmail())
				.name(request.getName())
				.birthDay(request.getBirthday())
				.sex(request.getSex())
				.userType(request.getUserType())
				.school(request.getSchool())
				.build()
		);
	}
}
