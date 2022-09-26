package com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebIdValidationRequest {
    @Size(max = 50, message = "아이디는 최대 50자까지 사용할 수 있습니다.")
    @NotBlank(message = "아이디는 비어있을 수 없습니다")
    private String accountId;
}
