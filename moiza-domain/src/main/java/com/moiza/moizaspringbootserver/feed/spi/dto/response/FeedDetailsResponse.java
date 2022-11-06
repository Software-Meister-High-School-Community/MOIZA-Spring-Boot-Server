package com.moiza.moizaspringbootserver.feed.spi.dto.response;

import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class FeedDetailsResponse {

    private final Author author;
    private final String title;
    private final String content;
    private final List<ImageUrl> imageUrls;
    private final LocalDateTime createdAt;
    private final FeedType feedType;
    private final String category;
    private final boolean isMine;
    private final boolean isUpdated;
    private final int LikeCount;
    private final int viewCount;
    private final List<Comment> comments;

    @Getter
    @Builder
    public static final class Author {
        private final UUID id;
        private final String profileImageUrl;
        private final String name;
        private final String schoolName;
        private final Type type;
    }

    @Getter
    @Builder
    public static final class ImageUrl {
        private final String imageUrl;
    }

    @Getter
    @Builder
    public static final class Comment {
        private final UUID id;
        private final Author author;
        private final boolean isMine;
        private final boolean isPinned;
        private final LocalDateTime createdAt;
        private final String content;
        private final List<ImageUrl> imageUrls;

        @Getter
        @Builder
        public static final class ChildComment {
            private final UUID id;
            private final UUID parentCommentId;
            private final Author author;
            private final boolean isMine;
            private final List<ImageUrl> imageUrls;
            private final LocalDateTime createdAt;
            private final String content;
        }
    }
}
