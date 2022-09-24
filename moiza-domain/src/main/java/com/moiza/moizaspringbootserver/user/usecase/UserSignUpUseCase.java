package com.moiza.moizaspringbootserver.user.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.exception.EmailCodeNotVerifiedException;
import com.moiza.moizaspringbootserver.user.User;
import com.moiza.moizaspringbootserver.user.api.UserSignUpApi;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserSignUpApiRequest;
import com.moiza.moizaspringbootserver.user.exception.UserAlreadyExistsException;
import com.moiza.moizaspringbootserver.user.spi.CommandUserPort;
import com.moiza.moizaspringbootserver.user.spi.QueryUserPort;
import com.moiza.moizaspringbootserver.user.spi.UserQueryEmailCodePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UserSignUpUseCase implements UserSignUpApi {

	private final QueryUserPort queryUserPort;
	private final UserQueryEmailCodePort userQueryEmailCodePort;
	private final CommandUserPort commandUserPort;

	@Override
	public void execute(DomainUserSignUpApiRequest request) {

		if (queryUserPort.existsUserByAccountId(request.getAccountId()) || queryUserPort.existsUserByEmail(request.getEmail())) {
			throw UserAlreadyExistsException.EXCEPTION;
		}

		if (!userQueryEmailCodePort.queryEmailCodeById(request.getEmail()).isVerify()) {
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

		commandUserPort.saveUser(user);
	}
}
