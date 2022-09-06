package com.moiza.moizaspringbootserver.domain.user.domain.repository;

import com.moiza.moizaspringbootserver.domain.user.domain.UserIntroduceLinkEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserIntroduceLinkRepository extends CrudRepository<UserIntroduceLinkEntity, UUID> {

}
