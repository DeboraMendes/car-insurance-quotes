package br.com.audsat.carinsurancequotes.domains.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Cliente do orçamento")
public class CustomerDTO {

    @Schema(description = "Identificação do cliente.", example = "1")
    private Long id;

    @Schema(description = "Nome do cliente.", example = "Renata Maldonado")
    private String name;

    @Schema(description = "Dados de motorista do cliente.")
    private DriverDTO driver;
}
