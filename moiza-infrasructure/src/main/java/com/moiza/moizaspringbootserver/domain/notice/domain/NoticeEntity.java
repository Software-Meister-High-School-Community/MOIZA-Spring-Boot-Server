package com.moiza.moizaspringbootserver.domain.notice.domain;


import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicInsert
@Table(name = "tbl_notice")
public class NoticeEntity extends BaseTimeEntity {

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull
    @ColumnDefault(value = "false")
    private boolean isPinned;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}