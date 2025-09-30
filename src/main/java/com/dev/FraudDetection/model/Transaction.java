package com.dev.FraudDetection.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import java.util.Map;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Users user;

    private BigDecimal amount;

    private String currency;

    private String cardLast4;

    private String cardNumber; // demo only; mask in UI

    private String status; // PENDING, FLAGGED, APPROVED, REJECTED

    private String merchant;

    private String geolocation;

    private Instant createdAt = Instant.now();

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;
}
