package com.awesomeorg.restaurantservice.repository;

import com.awesomeorg.restaurantservice.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class InternalReservationQuery {

    private Reservation.Status status;

    private Long customerId;

    private Long tableId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;
}
