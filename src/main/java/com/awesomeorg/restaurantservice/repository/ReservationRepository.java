package com.awesomeorg.restaurantservice.repository;

import com.awesomeorg.restaurantservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
