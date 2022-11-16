package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.request.DomainUpdateFeedRequest;

import java.util.UUID;

public interface UpdateFeedApi {

    void execute(UUID feedId, DomainUpdateFeedRequest request);

}
