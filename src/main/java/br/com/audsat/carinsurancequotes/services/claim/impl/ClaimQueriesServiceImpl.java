package br.com.audsat.carinsurancequotes.services.claim.impl;

import br.com.audsat.carinsurancequotes.repositories.ClaimRepository;
import br.com.audsat.carinsurancequotes.services.claim.ClaimQueriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClaimQueriesServiceImpl implements ClaimQueriesService {

    private final ClaimRepository claimRepository;

    @Override
    public Boolean existsClaimByCarId(final Long carId) {
        log.info("Exists claim by carId {}", carId);
        return claimRepository.existsByCarId(carId).isPresent();
    }

    @Override
    public Boolean existsClaimByDriverId(final Long driverId) {
        log.info("Exists claim by driverId {}", driverId);
        return claimRepository.existsByDriverId(driverId).isPresent();
    }
}
