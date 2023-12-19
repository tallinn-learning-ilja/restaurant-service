package com.awesomeorg.restaurantservice.entity;

import com.awesomeorg.restaurantservice.protocol.CreateCustomerRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "customers")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phoneNumber;

    private String emailAddress;

    public Customer(final CreateCustomerRequest request) {
        this.fullName = request.getFullName();
        this.emailAddress = request.getEmailAddress();
        this.phoneNumber = request.getPhoneNumber();
    }

}
