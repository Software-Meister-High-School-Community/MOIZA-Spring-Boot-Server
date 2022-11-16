package com.moiza.moizaspringbootserver.feed.api;

import java.util.UUID;

public interface DeleteLocalFeedApi {

    void execute(UUID feedId);
}
