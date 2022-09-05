package com.moiza.moizaspringbootserver.domain.notification.entity.repository;

import com.moiza.moizaspringbootserver.domain.notification.entity.NotificationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository extends CrudRepository<NotificationEntity, UUID> {
}
