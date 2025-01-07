package com.eureka.amq.configs;

import lombok.Data;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq.exchanges")
@Data
public class AmqExchanges {
    private String internal;

    @Bean
    public TopicExchange internalExchange() {
        return new TopicExchange(internal);
    }
}
