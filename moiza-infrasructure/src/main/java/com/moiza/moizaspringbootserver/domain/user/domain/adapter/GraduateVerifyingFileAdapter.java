package com.moiza.moizaspringbootserver.domain.user.domain.adapter;

import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.GraduateVerifyingFileRepository;
import com.moiza.moizaspringbootserver.domain.user.mapper.graduateverifyingfile.GraduateVerifyingFileMapper;
import com.moiza.moizaspringbootserver.user.domain.GraduateVerifyingFile;
import com.moiza.moizaspringbootserver.user.spi.GraduateVerifyingFileSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class GraduateVerifyingFileAdapter implements GraduateVerifyingFileSpi {

    private final GraduateVerifyingFileRepository graduateVerifyingFileRepository;
    private final GraduateVerifyingFileMapper graduateVerifyingFileMapper;

    @Override
    public void saveGraduateVerifyingFile(GraduateVerifyingFile graduateVerifyingFile) {
        graduateVerifyingFileRepository.save(
                graduateVerifyingFileMapper.graduateVerifyingFileDomainToEntity(graduateVerifyingFile)
        );
    }
}
