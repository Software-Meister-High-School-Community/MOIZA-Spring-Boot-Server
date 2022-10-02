package com.moiza.moizaspringbootserver.user.spi;

import java.util.List;
import java.util.UUID;

public interface UserQueryIntroduceLinkSpi {
    List<String> getIntroduceLinkList(UUID userId);
}
