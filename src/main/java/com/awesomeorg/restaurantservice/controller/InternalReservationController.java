package com.awesomeorg.restaurantservice.controller;

import com.awesomeorg.restaurantservice.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/reservations")
@RequiredArgsConstructor
public class InternalReservationController {

    private final ReservationService reservationService;
}
