package com.moiza.moizaspringbootserver.domain.feed.presentation;

import com.moiza.moizaspringbootserver.feed.api.DeleteFeedApi;
import com.moiza.moizaspringbootserver.feed.api.LocalFeedListApi;
import com.moiza.moizaspringbootserver.feed.api.response.LocalFeedListResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
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
    private final LocalFeedListApi localFeedListApi;
    private final AddFeedLikeApi addFeedLikeApi;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") UUID feedId) {
        deleteFeedApi.execute(feedId);
    }

    @GetMapping("/lists/temporaries")
    public LocalFeedListResponse getAllTemporaries(@RequestParam FeedType type, @RequestParam String category) {
        return localFeedListApi.execute(type, category);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{feed-id}/like")
    public void addFeedLike(@PathVariable(name = "feed-id") UUID feedId) {
        addFeedLikeApi.execute(feedId);
    }
}
