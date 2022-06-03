package org.polik.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.polik.customer.request.CustomerRegistrationRequest;
import org.polik.customer.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Polik on 5/31/2022
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public record CustomerController(CustomerService service) {

    @PostMapping
    public void register(@RequestBody CustomerRegistrationRequest customer) {
        log.info("register {}", customer);
        service.register(customer);
    }
}
