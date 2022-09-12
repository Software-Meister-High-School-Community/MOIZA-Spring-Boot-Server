package com.moiza.moizaspringbootserver.domain.user.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import com.moiza.moizaspringbootserver.user.enums.DefaultImage;
import com.moiza.moizaspringbootserver.user.enums.School;
import com.moiza.moizaspringbootserver.user.enums.Sex;
import com.moiza.moizaspringbootserver.user.enums.UserType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Entity
@Table(name = "tbl_user")
public class UserEntity extends BaseUUIDEntity {

    @NotNull
    @Length(max = 64)
    @Column(unique = true)
    private String email;

    @NotNull
    @Length(max = 50)
    @Column(unique = true)
    private String accountId;

    @NotNull
    @Length(max = 60)
    private String password;

    @NotNull
    @Length(max = 10)
    private String name;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    @Column(nullable = false)
    private String profileImageUrl;

    @Length(max = 7)
    @Column(nullable = false)
    @ColumnDefault("'NNNNNNN'")
    private String profileBackgroundColor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    private Long birthDay;

    @Length(max = 8)
    private String introduce;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private School school;
}