package com.eureka.clients.notification;

public record NotificationRequest(
        String email,
        String message
) {
}
