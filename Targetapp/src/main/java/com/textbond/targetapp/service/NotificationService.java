package com.textbond.targetapp.service;

import com.textbond.targetapp.model.Notification;
import com.textbond.targetapp.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public void createNotification(String userId, String message) {

        Notification notification = new Notification(userId, message);
        notificationRepository.save(notification);
    }

    // Get all notifications for a user
    public List<Notification> getNotificationsByUser(String userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Get unread notifications only
    public List<Notification> getUnreadNotifications(String userId) {
        return notificationRepository.findByUserIdAndReadFalse(userId);
    }

    public Notification markAsRead(String notificationId) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setRead(true);
        return notificationRepository.save(notification);
    }

}
