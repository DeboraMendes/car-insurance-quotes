package br.com.audsat.carinsurancequotes.repositories;

import br.com.audsat.carinsurancequotes.domains.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    @Override
    @Query(nativeQuery = true, value = "SELECT " +
            "       C.ID, " +
            "       C.MODEL, " +
            "       C.MANUFACTURER, " +
            "       C.CAR_YEAR, " +
            "       C.FIPE_VALUE " +
            "   FROM CAR_INSURANCE_QUOTES.CARS AS C " +
            "   WHERE C.ID = :id ")
    Optional<CarEntity> findById(final Long id);
}
