package br.com.audsat.carinsurancequotes.services.driver;

import br.com.audsat.carinsurancequotes.domains.entities.DriverEntity;
import br.com.audsat.carinsurancequotes.domains.pojo.IDriverEntity;

import java.util.List;

public interface DriverQueriesService {
    DriverEntity findMainDriverByCarId(final Long carId);

    DriverEntity findDriverByCustomerId(final Long customerId);

    List<IDriverEntity> findDriversByCarId(final Long carId);
}
