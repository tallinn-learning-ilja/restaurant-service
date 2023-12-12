package com.awesomeorg.restaurantservice.service;

import com.awesomeorg.restaurantservice.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;
}
