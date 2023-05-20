package br.com.audsat.carinsurancequotes.domains.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InsuranceCreationRequestDTO {

    @NotNull
    private Long customerId;

    @NotNull
    private Long carId;

    @NotNull
    private Boolean active;

}
