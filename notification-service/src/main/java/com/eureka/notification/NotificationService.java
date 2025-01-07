package com.eureka.notification;

import com.eureka.clients.notification.NotificationRequest;
import com.eureka.clients.notification.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    public NotificationResponse send(NotificationRequest request) {
        log.info("Sending notification request: {}", request);

        return NotificationResponse.builder()
                .isSuccess(true)
                .build();
    }
}
