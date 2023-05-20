package br.com.audsat.carinsurancequotes.repositories;

import br.com.audsat.carinsurancequotes.domains.entities.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClaimRepository extends JpaRepository<ClaimEntity, Long> {
    @Query(nativeQuery = true, value = " SELECT C.ID " +
            "   FROM CAR_INSURANCE_QUOTES.CLAIMS AS C " +
            "   WHERE C.CAR_ID = :carId " +
            "   LIMIT 1 ")
    Optional<Long> existsByCarId(final Long carId);

    @Query(nativeQuery = true, value = " SELECT C.ID " +
            "   FROM CAR_INSURANCE_QUOTES.CLAIMS AS C " +
            "   WHERE C.DRIVER_ID = :driverId " +
            "   LIMIT 1 ")
    Optional<Long> existsByDriverId(final Long driverId);
}
