package br.com.audsat.carinsurancequotes.adapters;

import br.com.audsat.carinsurancequotes.domains.dto.CarDTO;
import br.com.audsat.carinsurancequotes.domains.dto.CustomerDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceQueryResponseDTO;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;

public interface InsuranceQueryResponseDTOAdapter {
    static InsuranceQueryResponseDTO build(final InsuranceEntity insuranceEntity,
                                           final CustomerDTO customerDTO,
                                           final CarDTO carDTO) {
        return InsuranceQueryResponseDTO.builder()
                .id(insuranceEntity.getId())
                .customer(customerDTO)
                .creationDt(insuranceEntity.getCreationDt())
                .updatedAt(insuranceEntity.getUpdatedAt())
                .car(carDTO)
                .isActive(insuranceEntity.getIsActive())
                .fipePercentage(insuranceEntity.getFipePercentage())
                .amount(insuranceEntity.getAmount())
                .build();
    }
}
