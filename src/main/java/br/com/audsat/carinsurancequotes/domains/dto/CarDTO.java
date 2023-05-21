package br.com.audsat.carinsurancequotes.domains.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class CarDTO {
    private Long id;
    private String model;
    private String manufacturer;
    private Integer year;
    private BigDecimal fipeValue;
    private Boolean hasClaim;
    private Set<DriverDTO> drivers;
}
