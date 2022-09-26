package com.moiza.moizaspringbootserver.auth.spi;

import java.util.UUID;

public interface AuthSecuritySpi {
    String encodePassword(String password);

    boolean matches(String rawPassword, String encodedPassword);
    UUID getCurrentUserId();
}
