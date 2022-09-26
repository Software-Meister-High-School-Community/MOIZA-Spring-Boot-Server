package com.moiza.moizaspringbootserver.auth.spi;

public interface UserSecuritySpi {
	boolean matches(String rawPassword, String encodedPassword);
}
