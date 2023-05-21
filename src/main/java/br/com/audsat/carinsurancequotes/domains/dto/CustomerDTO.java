package br.com.audsat.carinsurancequotes.domains.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private DriverDTO driver;
}
