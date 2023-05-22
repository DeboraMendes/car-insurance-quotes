package br.com.audsat.carinsurancequotes.services.insurance;

import br.com.audsat.carinsurancequotes.domains.dto.InsuranceQueryResponseDTO;

public interface InsuranceQueriesService {
    InsuranceQueryResponseDTO findInsuranceById(final Long id);
}
