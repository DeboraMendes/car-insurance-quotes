package br.com.audsat.carinsurancequotes.controllers;

import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationRequestDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceQueryResponseDTO;
import org.springframework.http.ResponseEntity;

public interface InsuranceBudgetController {
    ResponseEntity<InsuranceCreationResponseDTO> createInsurance(final InsuranceCreationRequestDTO insuranceCreationRequestDTO);

    ResponseEntity<InsuranceQueryResponseDTO> findInsuranceById(final Long id);

    void updateInsuranceStatusById(final Long id, final Boolean active);

    void deleteInsuranceById(final Long id);
}
