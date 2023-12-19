package com.awesomeorg.restaurantservice.controller;

import com.awesomeorg.restaurantservice.entity.Customer;
import com.awesomeorg.restaurantservice.protocol.CreateCustomerRequest;
import com.awesomeorg.restaurantservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@Valid @RequestBody final CreateCustomerRequest request) {
        final Customer created = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(created);
    }
}
