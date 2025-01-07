package com.eureka.amq.configs;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq.routing-keys")
@Data
public class AmqBindings {
    private String notificationKey;

    @Bean
    public Binding bindingNotification(
            Queue notificationQueue,
            TopicExchange internalExchange
    ) {
        return BindingBuilder.bind(notificationQueue).to(internalExchange).with(notificationKey);
    }
}
