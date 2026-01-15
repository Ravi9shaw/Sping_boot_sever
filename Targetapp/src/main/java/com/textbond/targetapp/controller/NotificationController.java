package com.textbond.targetapp.controller;

import com.textbond.targetapp.model.Notification;
import com.textbond.targetapp.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@CrossOrigin("*")

public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getNotifications(
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(
                notificationService.getNotificationsByUser(userId)
        );
    }

    // 🔔 Get unread notifications only
    @GetMapping("/{userId}/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications(
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(
                notificationService.getUnreadNotifications(userId)
        );
    }

    @PatchMapping("/{notificationId}/read")
    //patch changes one particulaer field of an object
    //put changes the whole object
    public ResponseEntity<Notification> markNotificationAsRead(@PathVariable String notificationId) {
        return ResponseEntity.ok(
                notificationService.markAsRead(notificationId)
        );
    }

}
