package com.awesomeorg.restaurantservice.repository;

import com.awesomeorg.restaurantservice.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
}
