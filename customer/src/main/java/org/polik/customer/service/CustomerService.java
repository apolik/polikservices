package org.polik.customer.service;

import org.polik.customer.request.CustomerRegistrationRequest;
import org.polik.customer.model.Customer;
import org.polik.customer.repository.CustomerRepository;
import org.polik.customer.response.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Polik on 5/31/2022
 */
@Service
public record CustomerService(CustomerRepository repository, RestTemplate template) {
    public void register(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        repository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = template.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.fraudster()) {

            throw new IllegalStateException("Fraudster!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}
