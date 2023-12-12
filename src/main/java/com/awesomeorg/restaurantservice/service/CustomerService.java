package com.awesomeorg.restaurantservice.service;

import com.awesomeorg.restaurantservice.repository.BlocklistRepository;
import com.awesomeorg.restaurantservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BlocklistRepository blocklistRepository;
}
