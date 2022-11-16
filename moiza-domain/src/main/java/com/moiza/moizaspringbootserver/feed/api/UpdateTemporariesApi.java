package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.request.DomainUpdateTemporariesRequest;

import java.util.UUID;

public interface UpdateTemporariesApi {

    void execute(UUID feedId, DomainUpdateTemporariesRequest request);

}
