package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.spi.dto.response.SpiTokenResponse;

import java.util.UUID;

public interface JwtSpi {
    SpiTokenResponse getToken(String id);
}
