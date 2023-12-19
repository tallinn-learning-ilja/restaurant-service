package com.awesomeorg.restaurantservice.protocol;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String fullName;

    private String phoneNumber;

    private String emailAddress;
}
