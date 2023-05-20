package br.com.audsat.carinsurancequotes.repositories;

import br.com.audsat.carinsurancequotes.domains.entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {

    @Query(nativeQuery = true, value = " SELECT " +
            "       D.ID, " +
            "       D.DOCUMENT, " +
            "       D.BIRTHDATE " +
            "   FROM CAR_INSURANCE_QUOTES.DRIVERS AS D " +
            "   INNER JOIN CAR_INSURANCE_QUOTES.CUSTOMERS C " +
            "   ON C.DRIVER_ID = D.ID" +
            "   WHERE C.ID = :customerId ")
    Optional<DriverEntity> findDriverByCustomerId(final Long customerId);

    @Query(nativeQuery = true, value = " SELECT " +
            "       D.ID, " +
            "       D.DOCUMENT, " +
            "       D.BIRTHDATE " +
            "   FROM CAR_INSURANCE_QUOTES.DRIVERS AS D " +
            "   INNER JOIN CAR_INSURANCE_QUOTES.CAR_DRIVERS CD " +
            "   ON CD.DRIVER_ID = D.ID" +
            "   AND CD.CAR_ID = :carId " +
            "   WHERE CD.MAIN_DRIVER = true ")
    Optional<DriverEntity> findMainDriverByCarId(final Long carId);

}
