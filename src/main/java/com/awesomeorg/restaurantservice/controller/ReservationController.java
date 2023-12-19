package com.awesomeorg.restaurantservice.controller;

import com.awesomeorg.restaurantservice.entity.Reservation;
import com.awesomeorg.restaurantservice.protocol.CreateReservationRequest;
import com.awesomeorg.restaurantservice.service.ReservationService;
import com.awesomeorg.restaurantservice.util.HeaderConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody final CreateReservationRequest request,
                                                         @RequestHeader(HeaderConstants.CUSTOMER_ID_HEADER) Long customerId) {

        final Reservation reservation = reservationService.createReservation(request, customerId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservation);

    }
}
