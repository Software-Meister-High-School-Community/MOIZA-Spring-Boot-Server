package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.spi.dto.response.SpiTokenResponse;

public interface UserJwtSpi {
    SpiTokenResponse getToken(String id);
}
