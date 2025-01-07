package com.eureka.notification;

import com.eureka.clients.notification.NotificationClient;
import com.eureka.clients.notification.NotificationRequest;
import com.eureka.clients.notification.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController implements NotificationClient {
    private final NotificationService notificationService;

    @PostMapping
    public NotificationResponse send(@RequestBody NotificationRequest request) {
        return notificationService.send(request);
    }
}
