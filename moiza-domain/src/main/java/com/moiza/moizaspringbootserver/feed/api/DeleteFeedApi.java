package com.moiza.moizaspringbootserver.feed.api;

import java.util.UUID;

public interface DeleteFeedApi {

    void execute(UUID feedId);

}
