package org.polik.customer.request;

import lombok.Value;

import java.beans.ConstructorProperties;

/**
 * Created by Polik on 5/31/2022
 */
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
