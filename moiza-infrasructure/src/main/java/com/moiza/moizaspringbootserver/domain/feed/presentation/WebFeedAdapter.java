package com.moiza.moizaspringbootserver.domain.feed.presentation;

import com.moiza.moizaspringbootserver.feed.api.DeleteFeedApi;
import com.moiza.moizaspringbootserver.feed.api.LocalFeedDetailApi;
import com.moiza.moizaspringbootserver.feed.api.LocalFeedListApi;
import com.moiza.moizaspringbootserver.feed.api.PublishedFeedListApi;
import com.moiza.moizaspringbootserver.feed.api.SearchAllFeedsApi;
import com.moiza.moizaspringbootserver.feed.api.dto.response.LocalFeedDetailResponse;
import com.moiza.moizaspringbootserver.feed.api.dto.response.PublishedFeedListResponse;
import com.moiza.moizaspringbootserver.feed.api.dto.response.LocalFeedListResponse;
import com.moiza.moizaspringbootserver.feed.api.dto.response.SearchAllFeedsResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.type.QueryOrders;
import com.moiza.moizaspringbootserver.like.api.DiscardFeedLikeApi;
import com.moiza.moizaspringbootserver.like.api.AddFeedLikeApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class WebFeedAdapter {

    private final DeleteFeedApi deleteFeedApi;
    private final LocalFeedListApi localFeedListApi;
    private final DiscardFeedLikeApi discardFeedLikeApi;
    private final AddFeedLikeApi addFeedLikeApi;
    private final PublishedFeedListApi publishedFeedListApi;
    private final LocalFeedDetailApi localFeedDetailApi;
    private final SearchAllFeedsApi searchAllFeedsApi;

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
    @DeleteMapping("/{feed-id}/like")
    public void deleteFeedLike(@PathVariable(name = "feed-id") UUID feedId) {
        discardFeedLikeApi.execute(feedId);
    }
    
    @PostMapping("/{feed-id}/like")
    public void addFeedLike(@PathVariable(name = "feed-id") UUID feedId) {
        addFeedLikeApi.execute(feedId);
    }

    @GetMapping("/list/{user-id}")
    public PublishedFeedListResponse getFeeds(@PathVariable(value = "user-id", required = false) String userId,
                                              @RequestParam("category") String category,
                                              @RequestParam("type") String type,
                                              @RequestParam("order") String order,
                                              @RequestParam("page") int page) {
        return publishedFeedListApi.execute(userId.isEmpty() ? null : UUID.fromString(userId), category,
                type, order, page);
    }

    @GetMapping("/temporaries/{feed-id}")
    public LocalFeedDetailResponse getLocalFeedDetail(@PathVariable("feed-id") UUID feedId) {
        return localFeedDetailApi.execute(feedId);
    }

    @GetMapping("/searching")
    public SearchAllFeedsResponse searchAllFeeds(
            @NotBlank @RequestParam String name,
            @NotBlank @RequestParam String category,
            @NotBlank @RequestParam String type,
            @NotBlank @RequestParam String order,
            @NotNull @RequestParam Integer page
    ) {
        return searchAllFeedsApi.execute(name, category, FeedType.valueOf(type), QueryOrders.valueOf(order), page);
    }
}
