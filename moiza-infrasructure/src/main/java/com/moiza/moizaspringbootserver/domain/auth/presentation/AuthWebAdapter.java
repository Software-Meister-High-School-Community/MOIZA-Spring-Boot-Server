package com.moiza.moizaspringbootserver.domain.auth.presentation;

import com.moiza.moizaspringbootserver.auth.api.IdRecoveryApi;
import com.moiza.moizaspringbootserver.auth.api.dto.response.IdRecoveryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moiza.moizaspringbootserver.auth.api.IdValidationApi;
import com.moiza.moizaspringbootserver.auth.api.UserSignInApi;
import com.moiza.moizaspringbootserver.auth.api.TokenRefreshApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainUserSignInRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.SignInResponse;
import com.moiza.moizaspringbootserver.auth.api.dto.response.TokenRefreshResponse;
import com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request.WebIdValidationRequest;
import com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request.WebUserSignInRequest;
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
    private final UserSignInApi userSignInApi;
    private final TokenRefreshApi tokenRefreshApi;
    private final IdRecoveryApi idRecoveryApi;

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
    
    @RequestMapping("/tokens")
    public SignInResponse userSignIn(@RequestBody @Valid WebUserSignInRequest request) {
        return userSignInApi.execute(
            DomainUserSignInRequest.builder()
                .accountId(request.getAccountId())
                .password(request.getPassword())
                .appDeviceToken(request.getAppDeviceToken())
                .webDeviceToken(request.getWebDeviceToken())
            .build()
        );
    }

    @PutMapping("/tokens")
    public TokenRefreshResponse tokenRefresh(@RequestHeader("REFRESH-TOKEN") String token) {
        return tokenRefreshApi.execute(token);
    }
    
    @GetMapping("/{user-email}")
    public IdRecoveryResponse recoveryId(@PathVariable("user-email") String email) {
        return idRecoveryApi.execute(email);
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
