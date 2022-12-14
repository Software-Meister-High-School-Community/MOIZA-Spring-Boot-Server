package com.moiza.moizaspringbootserver.global.security;

import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.auth.spi.UserSecuritySpi;
import com.moiza.moizaspringbootserver.auth.exception.UserAuthQueryFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SecurityFacadeAdapter implements AuthSecuritySpi, UserSecuritySpi {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public UUID getCurrentUserId() {
        try {
            return UUID.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
        } catch (NullPointerException exception) {
            throw UserAuthQueryFailedException.EXCEPTION;
        }
    }
}
