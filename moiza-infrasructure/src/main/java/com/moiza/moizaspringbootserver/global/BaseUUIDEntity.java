package com.moiza.moizaspringbootserver.global;

import com.fasterxml.uuid.Generators;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseUUIDEntity {

    @Column(nullable = false)
    private final UUID id = Generators.timeBasedGenerator().generate();
}
