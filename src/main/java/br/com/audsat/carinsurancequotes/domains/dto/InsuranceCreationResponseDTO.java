package br.com.audsat.carinsurancequotes.domains.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@Schema(description = "Response body do cadastro de orçamento")
public class InsuranceCreationResponseDTO {

    @Schema(description = "Identificação do orçamento.", example = "1")
    private Long insuranceId;

    @Schema(description = "Percentual da fipe.", example = "10.00")
    private BigDecimal fipePercentage;

    @Schema(description = "Valor do orçamento.", example = "2278.00")
    private BigDecimal amount;
}
