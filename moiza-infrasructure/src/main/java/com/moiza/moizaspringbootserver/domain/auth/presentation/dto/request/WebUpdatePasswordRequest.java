package com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebUpdatePasswordRequest {

    @NotBlank(message = "new_password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
            "<=>?@＼^_`{|}~]{8,}$",
            message = "new_password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상이여야 합니다.")
    @Size(max = 60, message = "new_password는 60자 이하여야 합니다.")
    private String newPassword;

    @NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 50, message = "account_id는 50자 이하여야 합니다.")
    private String accountId;

    @Email(message = "올바른 email형식을 지켜주세요")
    @NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 64, message = "email은 64자 이하여야 합니다.")
    private String email;
}
