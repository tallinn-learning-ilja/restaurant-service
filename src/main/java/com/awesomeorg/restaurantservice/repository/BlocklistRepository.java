package com.awesomeorg.restaurantservice.repository;

import com.awesomeorg.restaurantservice.entity.BlocklistedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlocklistRepository extends JpaRepository<BlocklistedCustomer, Long> {

    Optional<BlocklistedCustomer> findBlocklistedCustomerByCustomerId(@Param("customerId") Long customerId);
}
