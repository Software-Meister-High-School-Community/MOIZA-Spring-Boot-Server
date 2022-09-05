package com.moiza.moizaspringbootserver.domain.notification.entity;

import com.moiza.moizaspringbootserver.domain.notification.entity.type.Type;
import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
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
    @Length(max = 9)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder
    public NotificationEntity(String title, String content, String data, Type type) {
        this.title = title;
        this.content = content;
        this.data = data;
        this.type = type;
    }
}
