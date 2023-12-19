package com.awesomeorg.restaurantservice.repository;

import com.awesomeorg.restaurantservice.entity.Table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TableRepository extends JpaRepository<Table, Long>, PagingAndSortingRepository<Table, Long> {
    @Query("SELECT t FROM tables t " +
            "LEFT JOIN reservations r ON t.id = r.tableId AND r.reservationDate = :date " +
            "WHERE r.id IS NULL")
    Page<Table> findFreeTables(@Param("date") LocalDate reservationDate, PageRequest pageRequest);
}
