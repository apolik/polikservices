package org.polik.fraud.controller;

import lombok.AllArgsConstructor;
import org.polik.clients.fraud.FraudCheckResponse;
import org.polik.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Polik on 5/31/2022
 */
@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService service;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        var fraudulent = service.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraudulent);
    }
}
