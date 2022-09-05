package com.moiza.moizaspringbootserver.domain.user.domain;

import com.moiza.moizaspringbootserver.domain.user.domain.enums.DefaultImage;
import com.moiza.moizaspringbootserver.domain.user.domain.enums.School;
import com.moiza.moizaspringbootserver.domain.user.domain.enums.Sex;
import com.moiza.moizaspringbootserver.domain.user.domain.enums.UserType;
import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import com.moiza.moizaspringbootserver.user.enums.DefaultImage;
import com.moiza.moizaspringbootserver.user.enums.School;
import com.moiza.moizaspringbootserver.user.enums.Sex;
import com.moiza.moizaspringbootserver.user.enums.UserType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
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

    @Builder
    public UserEntity(String email, String accountId, String password, String name,
                      Sex sex, Long birthDay, String introduce, UserType userType, School school) {
        this.email = email;
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.introduce = introduce;
        this.userType = userType;
        this.school = school;
    }
}