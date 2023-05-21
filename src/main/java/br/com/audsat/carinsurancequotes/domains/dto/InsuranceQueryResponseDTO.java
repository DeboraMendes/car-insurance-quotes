package br.com.audsat.carinsurancequotes.domains.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class InsuranceQueryResponseDTO {
    private Long id;
    private CustomerDTO customer;
    private LocalDateTime creationDt;
    private LocalDateTime updatedAt;
    private CarDTO car;
    private Boolean isActive;
    private BigDecimal fipePercentage;
    private BigDecimal amount;
}
