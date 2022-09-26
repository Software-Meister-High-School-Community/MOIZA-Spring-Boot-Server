package com.moiza.moizaspringbootserver.global.security;

import com.moiza.moizaspringbootserver.auth.spi.UserSecuritySpi;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SecurityFacadeAdapter implements UserSecuritySpi {

	private final PasswordEncoder passwordEncoder;

	@Override
	public boolean matches(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
