package org.polik.customer.service;

import org.polik.clients.fraud.FraudCheckResponse;
import org.polik.clients.fraud.FraudClient;
import org.polik.clients.notification.NotificationClient;
import org.polik.clients.notification.NotificationRequest;
import org.polik.customer.model.Customer;
import org.polik.customer.repository.CustomerRepository;
import org.polik.customer.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Polik on 5/31/2022
 */
@Service
public record CustomerService(CustomerRepository repository, FraudClient fraudClient, NotificationClient notificationClient) {
    public void register(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        repository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.fraudster()) {
            throw new IllegalStateException("Fraudster!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                "Hello, buddy!"
        );

        notificationClient.sendNotification(notificationRequest);
    }
}
