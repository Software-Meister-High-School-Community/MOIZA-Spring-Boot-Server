package com.moiza.moizaspringbootserver.domain.user.mapper.graduateverifyingfile;

import com.moiza.moizaspringbootserver.domain.user.domain.GraduateVerifyingFileEntity;
import com.moiza.moizaspringbootserver.user.domain.GraduateVerifyingFile;

public interface GraduateVerifyingFileMapper {
    GraduateVerifyingFileEntity graduateVerifyingFileDomainToEntity(GraduateVerifyingFile graduateVerifyingFile);
    GraduateVerifyingFile graduateVerifyingFileEntityToDomain(GraduateVerifyingFileEntity graduateVerifyingFileEntity);
}
