package br.com.audsat.carinsurancequotes.services.insurance;

import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationRequestDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;

public interface InsuranceCreationService {
    InsuranceCreationResponseDTO createInsurance(final InsuranceCreationRequestDTO insuranceCreationRequestDTO);
}
