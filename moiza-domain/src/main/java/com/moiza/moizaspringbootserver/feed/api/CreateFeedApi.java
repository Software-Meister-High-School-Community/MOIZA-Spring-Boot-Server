package com.moiza.moizaspringbootserver.feed.api;

import com.moiza.moizaspringbootserver.feed.api.dto.request.DomainCreateFeedRequest;

public interface CreateFeedApi {

    void execute(DomainCreateFeedRequest request);

}
