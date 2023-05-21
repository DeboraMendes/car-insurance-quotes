package br.com.audsat.carinsurancequotes.domains.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DriverDTO {
    private Long id;
    private String document;
    private LocalDate birthdate;
    private Integer yearsOld;
    private Boolean mainDriver;
    private Boolean hasClaim;
}
