package br.com.audsat.carinsurancequotes.domains.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Response body da consulta de orçamento")
public class InsuranceQueryResponseDTO {

    @Schema(description = "Identificação do orçamento.", example = "1")
    private Long id;

    @Schema(description = "Cliente do orçamento.")
    private CustomerDTO customer;

    @Schema(description = "Data da solicitação do orçamento.", example = "1")
    private LocalDateTime creationDt;

    @Schema(description = "Data da atualização do orçamento.", example = "1")
    private LocalDateTime updatedAt;

    @Schema(description = "Veículo segurado.")
    private CarDTO car;

    @Schema(description = "Flag para indicar se o orçamento está ativo.", example = "true")
    private Boolean isActive;

    @Schema(description = "Percentual da fipe.", example = "10.00")
    private BigDecimal fipePercentage;

    @Schema(description = "Valor do orçamento.", example = "2278.00")
    private BigDecimal amount;
}
