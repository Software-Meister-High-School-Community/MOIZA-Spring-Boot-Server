package com.moiza.moizaspringbootserver.user.spi;

import com.moiza.moizaspringbootserver.user.domain.GraduateVerifyingFile;

public interface CommandGraduateVerifyingFileSpi {
    void saveGraduateVerifyingFile(GraduateVerifyingFile graduateVerifyingFile);
}
