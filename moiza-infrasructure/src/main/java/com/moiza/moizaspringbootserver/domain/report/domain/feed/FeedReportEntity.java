package com.moiza.moizaspringbootserver.domain.report.domain.feed;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "tbl_feed_report")
public class FeedReportEntity {

    @EmbeddedId
    private FeedReportId id;
}
