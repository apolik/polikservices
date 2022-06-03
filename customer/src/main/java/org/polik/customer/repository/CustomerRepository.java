package org.polik.customer.repository;

import org.polik.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Polik on 2/1/2022
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
