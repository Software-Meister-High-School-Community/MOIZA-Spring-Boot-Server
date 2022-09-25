package com.moiza.moizaspringbootserver.domain.auth.presentation;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainSendAuthCodeRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.SendEmailAuthCodeResponse;
import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import com.moiza.moizaspringbootserver.auth.usecase.SendEmailAuthCodeUseCase;
import com.moiza.moizaspringbootserver.auth.usecase.VerifyEmailAuthCodeUseCase;
import com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request.WebSendEmailAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {

    private final SendEmailAuthCodeUseCase sendEmailAuthCodeUseCase;
    private final VerifyEmailAuthCodeUseCase verifyEmailAuthCodeUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/email-verifications")
    public SendEmailAuthCodeResponse sendEmailAuthCode(@RequestBody @Valid WebSendEmailAuthCodeRequest request) {

        DomainSendAuthCodeRequest domainSendAuthCodeRequest = DomainSendAuthCodeRequest.builder()
                .type(request.getType())
                .value(request.getValue())
                .build();

        return sendEmailAuthCodeUseCase.execute(domainSendAuthCodeRequest);
    }

    @RequestMapping(value = "/email-verifications", method = RequestMethod.HEAD)
    public void verifyEmailAuthCode(
            @RequestParam @NotBlank String email,
            @RequestParam @NotBlank String authCode,
            @RequestParam @NotBlank Type type
    ) {
        verifyEmailAuthCodeUseCase.execute(email, authCode, type);
    }
}
