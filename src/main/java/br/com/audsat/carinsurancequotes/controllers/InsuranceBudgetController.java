package br.com.audsat.carinsurancequotes.controllers;

import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationRequestDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import org.springframework.http.ResponseEntity;

public interface InsuranceBudgetController {
    ResponseEntity<InsuranceCreationResponseDTO> createInsurance(final InsuranceCreationRequestDTO insuranceCreationRequestDTO);
}
