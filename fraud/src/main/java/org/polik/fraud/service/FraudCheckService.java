package org.polik.fraud.service;

import lombok.extern.slf4j.Slf4j;
import org.polik.fraud.model.FraudCheckHistory;
import org.polik.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Polik on 5/31/2022
 */
@Slf4j
@Service
public record FraudCheckService(FraudCheckHistoryRepository repository) {
    public boolean isFraudulentCustomer(Integer id) {
        log.info("isFraudulentCustomer {}", id);
        repository.save(
                FraudCheckHistory.builder()
                        .fraudster(false)
                        .customerId(id)
                        .build()
        );

        return false;
    }
}
