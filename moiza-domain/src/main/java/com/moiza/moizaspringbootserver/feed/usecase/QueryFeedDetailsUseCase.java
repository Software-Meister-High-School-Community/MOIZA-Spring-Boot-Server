package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.FeedDetailsResponse;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryFeedDetailsUseCase {

    public FeedDetailsResponse execute(UUID feedId) {
        return null;
    }
}
