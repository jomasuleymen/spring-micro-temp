package com.eureka.customer;

import com.eureka.amq.RabbitmqProducer;
import com.eureka.amq.configs.AmqBindings;
import com.eureka.amq.configs.AmqExchanges;
import com.eureka.clients.fraud.FraudClient;
import com.eureka.clients.fraud.FraudResponse;
import com.eureka.clients.notification.NotificationClient;
import com.eureka.clients.notification.NotificationRequest;
import com.eureka.customer.dto.CustomerRegisterationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final RabbitmqProducer rabbitmqProducer;

    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final AmqBindings amqBindings;
    private final AmqExchanges amqExchanges;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Customer registerCustomer(@RequestBody CustomerRegisterationRequest request) {
        log.info("registerCustomer, {}", request);
        Customer customer = Customer.builder()
                .name(request.name())
                .build();

//        FraudResponse response = restTemplate.getForObject(
//                "http://FRAUD-APP/api/v1/fraud-checker/{name}",
//                FraudResponse.class,
//                customer.getName()
//        );

        FraudResponse response = fraudClient.checkForFraud(customer.getName());

        if (response == null || response.isFraud()) {
            log.info("fraud customer, {}", customer);
            throw new RuntimeException("Customer is fraud");
        }

        customer = customerRepository.save(customer);

        NotificationRequest notificationRequest = new NotificationRequest("email@gmail.com", "User " +
                                                                                             "successfully " +
                                                                                             "registered");
        notificationClient.send(notificationRequest);
        rabbitmqProducer.send(notificationRequest, amqExchanges.getInternal(),
                amqBindings.getNotificationKey());

        kafkaTemplate.send("users-2", customer);

        return customer;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
