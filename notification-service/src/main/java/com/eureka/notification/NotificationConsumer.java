package com.eureka.notification;

import com.eureka.amq.configs.AmqQueues;
import com.eureka.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationService notificationService;
    private final AmqQueues amqQueues;

    @RabbitListener(queues = {
            "#{amqQueues.notification}"
    })
    public void consume(NotificationRequest request) {
        notificationService.send(request);
    }
}
