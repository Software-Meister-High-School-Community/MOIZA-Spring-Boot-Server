package com.moiza.moizaspringbootserver.feed.spi.feedattachmentfile;

import com.moiza.moizaspringbootserver.feed.Feed;

public interface CommandFeedAttachmentFileSpi {
    void feedAttachmentFileDelete(Feed feed);
}
