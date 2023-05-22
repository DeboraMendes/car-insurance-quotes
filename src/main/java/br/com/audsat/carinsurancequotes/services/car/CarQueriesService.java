package br.com.audsat.carinsurancequotes.services.car;

import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;

public interface CarQueriesService {
    CarEntity findCarById(final Long id);
}
