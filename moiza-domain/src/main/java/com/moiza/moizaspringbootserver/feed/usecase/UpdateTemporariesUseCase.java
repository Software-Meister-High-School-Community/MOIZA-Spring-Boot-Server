package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.api.UpdateTemporariesApi;
import com.moiza.moizaspringbootserver.feed.api.dto.request.DomainUpdateTemporariesRequest;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.QueryLocalFeedSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class UpdateTemporariesUseCase implements UpdateTemporariesApi {

    private final QueryLocalFeedSpi queryLocalFeedSpi;

    @Override
    public void execute(UUID feedId, DomainUpdateTemporariesRequest request) {

        LocalFeed localFeed = queryLocalFeedSpi.getLocalFeedByFeedId(feedId);

        LocalFeed updatedLocalFeed = LocalFeed.builder()
                .feedId(localFeed.getFeedId())
                .content(request.getContent())
                .title(request.getTitle())
                .createdAt(localFeed.getCreatedAt())
                .build();
        //Todo 저장

    }
}
