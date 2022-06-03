package org.polik.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by Polik on 5/31/2022
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer customerId;

    private Boolean fraudster;

    @CreationTimestamp
    private LocalDateTime createAt;
}
