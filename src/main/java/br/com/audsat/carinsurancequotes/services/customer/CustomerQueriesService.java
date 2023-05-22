package br.com.audsat.carinsurancequotes.services.customer;

import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;

public interface CustomerQueriesService {
    CustomerEntity findCustomerById(final Long id);
}
