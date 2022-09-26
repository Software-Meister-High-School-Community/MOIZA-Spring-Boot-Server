package com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebUserSignInRequest {

	@NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String accountId;

	@NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String password;

	@Size(min = 64, max = 64, message = "app_device_token은 64자여야 합니다.")
	private String appDeviceToken;

	@Size(min = 64, max = 64, message = "web_device_token은 64자여야 합니다.")
	private String webDeviceToken;
}
