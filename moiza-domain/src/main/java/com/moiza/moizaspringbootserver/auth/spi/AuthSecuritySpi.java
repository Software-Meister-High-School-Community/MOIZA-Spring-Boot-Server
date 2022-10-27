package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.follow.spi.FollowAuthSecuritySpi;
import java.util.UUID;

public interface AuthSecuritySpi extends FollowAuthSecuritySpi {
    String encodePassword(String password);

    boolean matches(String rawPassword, String encodedPassword);
    UUID getCurrentUserId();
}
