package com.eureka.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification-service", path = "/api/v1/notification")
public interface NotificationClient {
    @PostMapping
    NotificationResponse send(@RequestBody NotificationRequest request);
}
