package br.com.audsat.carinsurancequotes.builders;

import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;

public interface InsuranceCreationResponseDTOBuilder {
    static InsuranceCreationResponseDTO build(final InsuranceEntity insuranceEntity) {
        return InsuranceCreationResponseDTO.builder()
                .insuranceId(insuranceEntity.getId())
                .fipePercentage(insuranceEntity.getFipePercentage())
                .amount(insuranceEntity.getAmount())
                .build();
    }
}
