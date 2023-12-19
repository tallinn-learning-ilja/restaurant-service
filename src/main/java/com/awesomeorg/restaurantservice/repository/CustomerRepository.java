package com.awesomeorg.restaurantservice.repository;

import com.awesomeorg.restaurantservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM customers c WHERE c.emailAddress = :email")
    Optional<Customer> findByEmail(@Param("email") String emailAddress);
}
