package com.moiza.moizaspringbootserver.domain.auth.presentation;

import com.moiza.moizaspringbootserver.auth.api.IdValidationApi;
import com.moiza.moizaspringbootserver.auth.api.UserSignInApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainUserSignInRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.SignInResponse;
import com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request.WebIdValidationRequest;
import com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request.WebUserSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {
    private final IdValidationApi idValidationApi;
    private final UserSignInApi userSignInApi;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/id-validations", method = RequestMethod.HEAD)
    public void validId(@RequestBody @Valid WebIdValidationRequest request) {
        idValidationApi.execute(new DomainIdValidationRequest(request.getAccountId()));
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
}
