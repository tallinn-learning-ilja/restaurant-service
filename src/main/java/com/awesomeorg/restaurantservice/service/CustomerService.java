package com.awesomeorg.restaurantservice.service;

import com.awesomeorg.restaurantservice.entity.BlocklistedCustomer;
import com.awesomeorg.restaurantservice.entity.Customer;
import com.awesomeorg.restaurantservice.exceptions.CustomerAlreadyExistsException;
import com.awesomeorg.restaurantservice.protocol.CreateCustomerRequest;
import com.awesomeorg.restaurantservice.repository.BlocklistRepository;
import com.awesomeorg.restaurantservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BlocklistRepository blocklistRepository;

    public Customer createCustomer(final CreateCustomerRequest request) {
        final Optional<Customer> optionalCustomer = customerRepository.findByEmail(request.getEmailAddress());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with this email address");
        }
        final Customer customer = new Customer(request);
        return customerRepository.save(customer);
    }

    public Optional<BlocklistedCustomer> findBlockListedCustomer(final Long customerId) {
        return blocklistRepository.findBlocklistedCustomerByCustomerId(customerId);
    }
}
