package br.com.audsat.carinsurancequotes.mappers;

import br.com.audsat.carinsurancequotes.domains.dto.CarDTO;
import br.com.audsat.carinsurancequotes.domains.dto.CustomerDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceQueryResponseDTO;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;

public interface InsuranceMapper {
    static InsuranceCreationResponseDTO toDto(final InsuranceEntity insuranceEntity) {
        return InsuranceCreationResponseDTO.builder()
                .insuranceId(insuranceEntity.getId())
                .fipePercentage(insuranceEntity.getFipePercentage())
                .amount(insuranceEntity.getAmount())
                .build();
    }

    static InsuranceQueryResponseDTO toDto(final InsuranceEntity insuranceEntity,
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
