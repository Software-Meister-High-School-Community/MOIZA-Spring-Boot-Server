package com.moiza.moizaspringbootserver.domain.notification.domain;

import com.moiza.moizaspringbootserver.notification.type.Type;
import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_notification")
public class NotificationEntity extends BaseTimeEntity {

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;

    @NotNull
    @Length(max = 5)
    private String data;

    @NotNull
    @Column(length = 9)
    @Enumerated(EnumType.STRING)
    private Type type;
}
