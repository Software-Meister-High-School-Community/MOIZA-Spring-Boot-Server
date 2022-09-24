package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.exception.EmailCodeNotVerifiedException;
import com.moiza.moizaspringbootserver.user.User;
import com.moiza.moizaspringbootserver.user.api.UserSignUpApi;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserSignUpRequest;
import com.moiza.moizaspringbootserver.user.exception.UserAlreadyExistsException;
import com.moiza.moizaspringbootserver.user.spi.CommandUserSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import com.moiza.moizaspringbootserver.user.spi.UserQueryEmailCodeSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UserSignUpUseCase implements UserSignUpApi {

	private final QueryUserSpi queryUserSpi;
	private final UserQueryEmailCodeSpi userQueryEmailCodeSpi;
	private final CommandUserSpi commandUserSpi;

	@Override
	public void execute(DomainUserSignUpRequest request) {

		if (queryUserSpi.existsUserByAccountId(request.getAccountId()) || queryUserSpi.existsUserByEmail(request.getEmail())) {
			throw UserAlreadyExistsException.EXCEPTION;
		}

		if (!userQueryEmailCodeSpi.queryEmailCodeById(request.getEmail()).isVerify()) {
			throw EmailCodeNotVerifiedException.EXCEPTION;
		}

		User user = User.builder()
			.accountId(request.getAccountId())
			.password(request.getPassword())
			.email(request.getEmail())
			.name(request.getName())
			.birthDay(request.getBirthDay())
			.sex(request.getSex())
			.userType(request.getUserType())
			.school(request.getSchool())
			.build();

		commandUserSpi.saveUser(user);
	}
}
