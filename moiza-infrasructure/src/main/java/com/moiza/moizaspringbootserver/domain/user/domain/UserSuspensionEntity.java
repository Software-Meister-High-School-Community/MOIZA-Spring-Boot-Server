package com.moiza.moizaspringbootserver.domain.user.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user_suspension")
public class UserSuspensionEntity extends BaseTimeEntity {

    @NotNull
    private LocalDateTime expiredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

}
