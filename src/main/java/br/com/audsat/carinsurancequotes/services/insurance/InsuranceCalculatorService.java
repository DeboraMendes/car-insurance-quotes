package br.com.audsat.carinsurancequotes.services.insurance;

import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;

public interface InsuranceCalculatorService {
    void calculateInsurance(final InsuranceEntity insuranceEntity);
}
