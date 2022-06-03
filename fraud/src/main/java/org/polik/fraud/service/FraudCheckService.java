package org.polik.fraud.service;

import org.polik.fraud.model.FraudCheckHistory;
import org.polik.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Polik on 5/31/2022
 */
@Service
public record FraudCheckService(FraudCheckHistoryRepository repository) {
    public boolean isFraudulentCustomer(Integer id) {
        repository.save(
                FraudCheckHistory.builder()
                        .id(id)
                        .fraudster(false)
                        .build()
        );

        return false;
    }
}
