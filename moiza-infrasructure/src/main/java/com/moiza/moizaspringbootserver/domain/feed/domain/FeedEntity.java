package com.moiza.moizaspringbootserver.domain.feed.domain;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed")
public class FeedEntity extends BaseUUIDEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    private FeedType feedType;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private CategoryEntity category;

}
