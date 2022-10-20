package com.moiza.moizaspringbootserver.domain.feed.presentation;

import com.moiza.moizaspringbootserver.feed.api.DeleteFeedApi;
import com.moiza.moizaspringbootserver.like.api.DiscardFeedLikeApi;
import com.moiza.moizaspringbootserver.like.api.AddFeedLikeApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class WebFeedAdapter {

    private final DeleteFeedApi deleteFeedApi;
    private final DiscardFeedLikeApi discardFeedLikeApi;
    private final AddFeedLikeApi addFeedLikeApi;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") UUID feedId) {
        deleteFeedApi.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}/like")
    public void addFeedLike(@PathVariable(name = "feed-id") UUID feedId) {
        discardFeedLikeApi.execute(feedId);
    }
    
    @PostMapping("/{feed-id}/like")
    public void addFeedLike(@PathVariable(name = "feed-id") UUID feedId) {
        addFeedLikeApi.execute(feedId);
    }
}
