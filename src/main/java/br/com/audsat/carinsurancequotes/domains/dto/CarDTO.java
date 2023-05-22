package br.com.audsat.carinsurancequotes.domains.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@Schema(description = "Veículo segurado")
public class CarDTO {

    @Schema(description = "Identificação do veículo.", example = "1")
    private Long id;

    @Schema(description = "Modelo do veículo.", example = "Strada Opening Edition 1.3 Flex 8V Cd")
    private String model;

    @Schema(description = "Fabricante do veículo.", example = "Fiat")
    private String manufacturer;

    @Schema(description = "Ano do modelo do veículo.", example = "2003")
    private Integer year;

    @Schema(description = "Valor do veículo.", example = "22780.00")
    private BigDecimal fipeValue;

    @Schema(description = "Flag para indicar se o veículo possui sinistro.", example = "false")
    private Boolean hasClaim;

    @Schema(description = "Motoristas do veículo.")
    private Set<DriverDTO> drivers;
}
