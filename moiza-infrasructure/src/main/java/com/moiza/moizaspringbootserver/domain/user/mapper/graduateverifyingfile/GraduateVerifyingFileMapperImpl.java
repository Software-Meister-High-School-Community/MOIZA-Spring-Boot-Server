package com.moiza.moizaspringbootserver.domain.user.mapper.graduateverifyingfile;

import com.moiza.moizaspringbootserver.domain.user.domain.GraduateVerifyingFileEntity;
import com.moiza.moizaspringbootserver.user.domain.GraduateVerifyingFile;
import org.springframework.stereotype.Component;

@Component
public class GraduateVerifyingFileMapperImpl implements GraduateVerifyingFileMapper {

    @Override
    public GraduateVerifyingFileEntity graduateVerifyingFileDomainToEntity(GraduateVerifyingFile graduateVerifyingFile) {
        return GraduateVerifyingFileEntity.builder()
                .id(graduateVerifyingFile.getUserId())
                .verifyingFileUrl(graduateVerifyingFile.getVerifyingFileUrl())
                .build();
    }

    @Override
    public GraduateVerifyingFile graduateVerifyingFileEntityToDomain(GraduateVerifyingFileEntity graduateVerifyingFileEntity) {
        return GraduateVerifyingFile.builder()
                .userId(graduateVerifyingFileEntity.getUserEntity().getId())
                .verifyingFileUrl(graduateVerifyingFileEntity.getVerifyingFileUrl())
                .build();
    }
}
