package com.eureka.amq.configs;

import lombok.Data;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq.queues")
@Data
public class AmqQueues {
    private String notification;

    @Bean
    public Queue notificationQueue() {
        return new Queue(notification);
    }
}
