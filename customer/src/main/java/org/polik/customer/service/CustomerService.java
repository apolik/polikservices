package org.polik.customer.service;

import lombok.AllArgsConstructor;
import org.polik.amqp.producer.RabbitMQMessageProducer;
import org.polik.clients.fraud.FraudCheckResponse;
import org.polik.clients.fraud.FraudClient;
import org.polik.clients.notification.NotificationRequest;
import org.polik.customer.model.Customer;
import org.polik.customer.repository.CustomerRepository;
import org.polik.customer.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Polik on 5/31/2022
 */
@Service
@AllArgsConstructor
public final class CustomerService {
    private final CustomerRepository repository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer messageProducer;

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

        messageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
