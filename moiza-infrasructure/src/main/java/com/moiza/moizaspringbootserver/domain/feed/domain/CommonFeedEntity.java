package com.moiza.moizaspringbootserver.domain.feed.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class CommonFeedEntity extends BaseTimeEntity {

    @MapsId
    @JoinColumn(name = "feed_id")
    @OneToOne
    private FeedEntity feed;

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;

}
