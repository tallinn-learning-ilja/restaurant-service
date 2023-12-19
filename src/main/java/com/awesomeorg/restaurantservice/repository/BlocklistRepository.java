package com.awesomeorg.restaurantservice.repository;

import com.awesomeorg.restaurantservice.entity.BlocklistedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocklistRepository extends JpaRepository<BlocklistedCustomer, Long> {
}
