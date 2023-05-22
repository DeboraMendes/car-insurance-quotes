package br.com.audsat.carinsurancequotes.controllers.impl;

import br.com.audsat.carinsurancequotes.controllers.InsuranceBudgetController;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationRequestDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceCreationResponseDTO;
import br.com.audsat.carinsurancequotes.domains.dto.InsuranceQueryResponseDTO;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceCreationService;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceDeleterService;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceQueriesService;
import br.com.audsat.carinsurancequotes.services.insurance.InsuranceStatusUpdaterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurances/budgets")
@RequiredArgsConstructor
public class InsuranceBudgetControllerImpl implements InsuranceBudgetController {

    private final InsuranceCreationService insuranceCreationService;
    private final InsuranceQueriesService insuranceQueriesService;
    private final InsuranceStatusUpdaterService insuranceStatusUpdaterService;
    private final InsuranceDeleterService insuranceDeleterService;

    @Override
    @PostMapping
    public ResponseEntity<InsuranceCreationResponseDTO> createInsurance(@Valid @RequestBody final InsuranceCreationRequestDTO insuranceCreationRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(insuranceCreationService.createInsurance(insuranceCreationRequestDTO));
    }

    @Override
    @GetMapping("/{insurance-id}")
    public ResponseEntity<InsuranceQueryResponseDTO> findInsuranceById(@PathVariable("insurance-id") final Long id) {
        return ResponseEntity.ok(insuranceQueriesService.findInsuranceById(id));
    }

    @Override
    @PatchMapping("/{insurance-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInsuranceStatusById(@PathVariable("insurance-id") final Long id,
                                          @RequestParam("active") final Boolean active) {
        insuranceStatusUpdaterService.updateInsuranceStatusById(id, active);
    }

    @Override
    @DeleteMapping("/{insurance-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInsuranceById(@PathVariable("insurance-id") final Long id) {
        insuranceDeleterService.deleteInsuranceById(id);
    }

}
