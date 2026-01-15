package com.textbond.targetapp.repository;

import com.textbond.targetapp.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification,String> {

    List<Notification> findByUserId(String userId);

    List<Notification> findByUserIdAndReadFalse(String orderId);
}
