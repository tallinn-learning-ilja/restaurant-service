package com.awesomeorg.restaurantservice.service;

import com.awesomeorg.restaurantservice.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
}
