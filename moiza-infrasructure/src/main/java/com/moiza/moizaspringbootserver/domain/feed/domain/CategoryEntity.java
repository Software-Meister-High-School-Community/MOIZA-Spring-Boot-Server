package com.moiza.moizaspringbootserver.domain.feed.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_category")
public class CategoryEntity extends BaseUUIDEntity {

    @NotNull
    @Length(max = 10)
    private String categoryName;

}
