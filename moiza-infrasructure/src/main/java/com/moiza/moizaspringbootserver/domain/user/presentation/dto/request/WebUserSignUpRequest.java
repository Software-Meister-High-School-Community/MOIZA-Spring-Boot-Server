package com.moiza.moizaspringbootserver.domain.user.presentation.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.moiza.moizaspringbootserver.user.domain.enums.School;
import com.moiza.moizaspringbootserver.user.domain.enums.Sex;
import com.moiza.moizaspringbootserver.user.domain.enums.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebUserSignUpRequest {

	@NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	@Size(max = 50, message = "account_id는 50자 이하여야 합니다.")
	private String accountId;

	@NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
		"<=>?@＼^_`{|}~]{8,}$",
		message = "password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상이여야 합니다.")
	@Size(max = 60, message = "password는 60자 이하여야 합니다.")
	private String password;

	@Email(message = "올바른 email형식을 지켜주세요")
	@NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	@Size(max = 64, message = "email은 64자 이하여야 합니다.")
	private String email;

	@NotBlank(message = "name는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	@Size(max = 10, message = "name은 10자 이하여야 합니다.")
	private String name;

	@NotNull(message = "birthday는 Null을 허용하지 않습니다.")
	@Size(max = 8, message = "birthday는 8자 이하여야 합니다.")
	private String birthday;

	@NotNull(message = "sex는 Null을 허용하지 않습니다.")
	private Sex sex;

	@NotNull(message = "userType는 Null을 허용하지 않습니다.")
	private UserType userType;

	@NotNull(message = "school는 Null을 허용하지 않습니다.")
	private School school;
}
