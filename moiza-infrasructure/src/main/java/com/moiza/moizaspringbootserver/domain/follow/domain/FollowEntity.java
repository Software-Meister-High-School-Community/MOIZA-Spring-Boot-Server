package com.moiza.moizaspringbootserver.domain.follow.domain;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "tbl_follow")
public class FollowEntity extends BaseTimeEntity {

    @EmbeddedId
    private FollowId followId;

    @MapsId("user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @NotNull
    private LocalDateTime createdAt;

    @MapsId("targetUser")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_user_id", nullable = false)
    private UserEntity targetUser;
}
