package br.com.audsat.carinsurancequotes.domains.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "insurances")
public class InsuranceEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customer;

    @Column(name = "creation_dt")
    private LocalDateTime creationDt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity car;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "fipe_percentage")
    private BigDecimal fipePercentage;

    @Column(name = "amount")
    private BigDecimal amount;

}
