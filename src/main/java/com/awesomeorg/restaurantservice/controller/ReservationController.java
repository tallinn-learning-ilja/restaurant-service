package com.awesomeorg.restaurantservice.controller;

import com.awesomeorg.restaurantservice.entity.Reservation;
import com.awesomeorg.restaurantservice.protocol.CreateReservationRequest;
import com.awesomeorg.restaurantservice.service.ReservationService;
import com.awesomeorg.restaurantservice.util.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Create reservation for the given date if all requirements are met")
    @ApiResponses(@ApiResponse(description = "Create reservation", content = @Content(schema = @Schema(implementation = Reservation.class))))
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody final CreateReservationRequest request,
                                                         @RequestHeader(HeaderConstants.CUSTOMER_ID_HEADER) Long customerId) {

        final Reservation reservation = reservationService.createReservation(request, customerId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservation);

    }
}
