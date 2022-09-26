package com.moiza.moizaspringbootserver.global.security;

import com.moiza.moizaspringbootserver.auth.spi.UserSecuritySpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Adapter
public class SecurityFacadeAdapter implements UserSecuritySpi {

	private final PasswordEncoder passwordEncoder;

	@Override
	public boolean matches(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
