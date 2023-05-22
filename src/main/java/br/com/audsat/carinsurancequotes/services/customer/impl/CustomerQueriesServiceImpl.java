package br.com.audsat.carinsurancequotes.services.customer.impl;

import br.com.audsat.carinsurancequotes.domains.entities.CustomerEntity;
import br.com.audsat.carinsurancequotes.exceptions.ResourceNotFoundException;
import br.com.audsat.carinsurancequotes.repositories.CustomerRepository;
import br.com.audsat.carinsurancequotes.services.customer.CustomerQueriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerQueriesServiceImpl implements CustomerQueriesService {

    private final CustomerRepository customerRepository;

    public CustomerEntity findCustomerById(final Long id) {
        log.info("Find customer by id {}", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found."));
    }
}
