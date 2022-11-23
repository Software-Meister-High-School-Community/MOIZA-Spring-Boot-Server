package com.moiza.moizaspringbootserver.feed.spi.feedattachmentfile;

import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.FeedAttachmentFile;

public interface CommandFeedAttachmentFileSpi {
    void deleteAllFeedAttachmentFileByFeedId(Feed feed);
    void saveFeedAttachmentFile(FeedAttachmentFile feedAttachmentFile);

}
