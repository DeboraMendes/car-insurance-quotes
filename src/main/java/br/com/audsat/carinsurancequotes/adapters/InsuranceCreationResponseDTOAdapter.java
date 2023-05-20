package br.com.audsat.carinsurancequotes.adapters;

import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;

public interface InsuranceCreationResponseDTOAdapter {
    static InsuranceCreationResponseDTO build(final InsuranceEntity insuranceEntity) {
        return InsuranceCreationResponseDTO.builder()
                .insuranceId(insuranceEntity.getId())
                .fipePercentage(insuranceEntity.getFipePercentage())
                .amount(insuranceEntity.getAmount())
                .build();
    }
}
