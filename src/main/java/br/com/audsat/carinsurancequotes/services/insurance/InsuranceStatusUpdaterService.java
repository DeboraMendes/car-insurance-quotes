package br.com.audsat.carinsurancequotes.services.insurance;

public interface InsuranceStatusUpdaterService {
    void updateInsuranceStatusById(final Long id, final Boolean active);
}
