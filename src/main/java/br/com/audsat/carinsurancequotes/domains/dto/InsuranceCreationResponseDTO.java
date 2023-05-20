package br.com.audsat.carinsurancequotes.domains.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class InsuranceCreationResponseDTO {
    private Long insuranceId;
    private BigDecimal fipePercentage;
    private BigDecimal amount;
}
