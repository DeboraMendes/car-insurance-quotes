package br.com.audsat.carinsurancequotes.controllers.impl;

import br.com.audsat.carinsurancequotes.controllers.InsuranceBudgetController;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationRequestDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceCreationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurances/budgets")
@RequiredArgsConstructor
public class InsuranceBudgetControllerImpl implements InsuranceBudgetController {

    private final InsuranceCreationService insuranceCreationService;

    @Override
    @PostMapping
    public ResponseEntity<InsuranceCreationResponseDTO> createInsurance(@Valid @RequestBody final InsuranceCreationRequestDTO insuranceCreationRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(insuranceCreationService.createInsurance(insuranceCreationRequestDTO));
    }

}
