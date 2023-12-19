package com.awesomeorg.restaurantservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;

    private Integer numberOfGuests;

    @Enumerated(EnumType.STRING)
    private Status reservationStatus;

    private Long customerId;

    private Long tableId;


    public enum Status {
        PENDING,
        CONFIRMED,
        CANCELLED,
        NOT_ARRIVED,
        FINISHED
    }
}
