package org.polik.fraud.repository;

import org.polik.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Polik on 2/1/2022
 */
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
