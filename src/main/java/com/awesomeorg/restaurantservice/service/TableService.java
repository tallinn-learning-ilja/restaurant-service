package com.awesomeorg.restaurantservice.service;

import com.awesomeorg.restaurantservice.entity.Table;
import com.awesomeorg.restaurantservice.protocol.TableQuery;
import com.awesomeorg.restaurantservice.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;

    public Optional<Table> findTableById(final Long tableId) {
        return tableRepository.findById(tableId);
    }

    public Page<Table> findFreeTables(TableQuery query, PageRequest pageRequest) {
        return tableRepository.findFreeTables(query.getReservationDate(), pageRequest);
    }
}
