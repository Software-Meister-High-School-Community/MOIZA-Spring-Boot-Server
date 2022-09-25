package com.moiza.moizaspringbootserver.domain.auth.presentation;

import com.moiza.moizaspringbootserver.auth.api.IdRecoveryApi;
import com.moiza.moizaspringbootserver.auth.api.dto.response.IdRecoveryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthWebAdapter {
    private final IdRecoveryApi idRecoveryApi;

    @GetMapping("/{user-email}")
    public IdRecoveryResponse recoveryId(@PathVariable("user-email") String email) {
        return idRecoveryApi.execute(email);
    }
}