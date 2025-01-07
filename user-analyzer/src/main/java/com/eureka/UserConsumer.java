package com.eureka;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class UserConsumer {

    @KafkaListener(topics = {"users-2"}, groupId = "analyzer2")
    void listen(String data, String data2) {
        System.out.println(data);
        System.out.println(data2);
    }
}
