package com.moiza.moizaspringbootserver.domain.auth.presentation;

import com.moiza.moizaspringbootserver.auth.api.IdValidationApi;
import com.moiza.moizaspringbootserver.auth.api.TokenRefreshApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.TokenRefreshResponse;
import com.moiza.moizaspringbootserver.domain.auth.presentation.dto.request.WebIdValidationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {
    private final IdValidationApi idValidationApi;
    private final TokenRefreshApi tokenRefreshApi;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/id-validations", method = RequestMethod.HEAD)
    public void validId(@RequestBody @Valid WebIdValidationRequest request) {
        idValidationApi.execute(new DomainIdValidationRequest(request.getAccountId()));
    }

    @PutMapping("/tokens")
    public TokenRefreshResponse tokenRefresh(@RequestHeader("REFRESH-TOKEN") String token) {
        return tokenRefreshApi.execute(token);
    }
}
