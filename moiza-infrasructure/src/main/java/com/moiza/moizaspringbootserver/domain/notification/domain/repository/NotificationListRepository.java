package com.moiza.moizaspringbootserver.domain.notification.domain.repository;

import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationListEntity;
import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationListId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationListRepository extends CrudRepository<NotificationListEntity, NotificationListId> {
}
