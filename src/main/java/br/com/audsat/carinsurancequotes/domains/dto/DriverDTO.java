package br.com.audsat.carinsurancequotes.domains.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@Schema(description = "Motorista do veículo")
public class DriverDTO {

    @Schema(description = "Identificação do motorista.", example = "1")
    private Long id;

    @Schema(description = "CNH do motorista.", example = "38545528201")
    private String document;

    @Schema(description = "Data de nascimento do motorista.", example = "2000-05-20")
    private LocalDate birthdate;

    @Schema(description = "Idade do motorista.", example = "23")
    private Integer yearsOld;

    @Schema(description = "Flag para indicar se o motorista é o principal condutor do veículo.", example = "true")
    private Boolean mainDriver;

    @Schema(description = "Flag para indicar se o motorista possui sinistro.", example = "true")
    private Boolean hasClaim;
}
