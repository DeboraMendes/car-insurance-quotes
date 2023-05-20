package br.com.audsat.carinsurancequotes.services.driver;

import br.com.audsat.carinsurancequotes.domains.entities.DriverEntity;

public interface DriverQueriesService {
    DriverEntity findMainDriverByCarId(final Long carId);

    DriverEntity findDriverByCustomerId(final Long customerId);
}
