package br.com.audsat.carinsurancequotes.services.claim;

public interface ClaimQueriesService {
    Boolean existsClaimByCarId(final Long carId);

    Boolean existsClaimByDriverId(final Long driveId);
}
