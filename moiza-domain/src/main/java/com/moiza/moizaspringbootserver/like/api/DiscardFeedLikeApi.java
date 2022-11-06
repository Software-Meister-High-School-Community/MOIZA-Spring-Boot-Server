package com.moiza.moizaspringbootserver.like.api;

import java.util.UUID;

public interface DiscardFeedLikeApi {
    void execute(UUID feedId);
}
