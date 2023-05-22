package br.com.audsat.carinsurancequotes.repositories;

import br.com.audsat.carinsurancequotes.domains.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
