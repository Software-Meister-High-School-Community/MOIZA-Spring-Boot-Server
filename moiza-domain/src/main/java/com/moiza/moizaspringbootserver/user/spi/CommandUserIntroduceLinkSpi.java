package com.moiza.moizaspringbootserver.user.spi;

import java.util.List;
import java.util.UUID;

public interface CommandUserIntroduceLinkSpi {
    void updateLinksByUserId(UUID id, List<String> links);
}
