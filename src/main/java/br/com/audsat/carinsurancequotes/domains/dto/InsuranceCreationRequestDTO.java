package br.com.audsat.carinsurancequotes.domains.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Request body do cadastro de orçamento.")
public class InsuranceCreationRequestDTO {

    @NotNull
    @Schema(description = "Identificação do cliente.", example = "1")
    private Long customerId;

    @NotNull
    @Schema(description = "Identificação do veículo.", example = "1")
    private Long carId;

    @NotNull
    @Schema(description = "Flag para indicar se o orçamento está ativo.", example = "true")
    private Boolean active;

}
