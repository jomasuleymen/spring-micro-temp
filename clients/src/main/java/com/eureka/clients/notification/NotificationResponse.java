package com.eureka.clients.notification;

import lombok.Builder;

@Builder
public record NotificationResponse(
        Boolean isSuccess
) {
}
