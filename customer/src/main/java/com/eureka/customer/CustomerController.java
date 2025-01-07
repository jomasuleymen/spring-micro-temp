package com.eureka.customer;

import com.eureka.customer.dto.CustomerRegisterationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    private void registerCustomer(@RequestBody CustomerRegisterationRequest request) {
        customerService.registerCustomer(request);
    }

    @GetMapping
    private List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
