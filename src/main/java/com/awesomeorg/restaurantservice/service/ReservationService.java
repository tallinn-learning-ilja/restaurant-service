package com.awesomeorg.restaurantservice.service;

import com.awesomeorg.restaurantservice.entity.BlocklistedCustomer;
import com.awesomeorg.restaurantservice.entity.Reservation;
import com.awesomeorg.restaurantservice.entity.Table;
import com.awesomeorg.restaurantservice.exceptions.BadRequestException;
import com.awesomeorg.restaurantservice.exceptions.NotFoundException;
import com.awesomeorg.restaurantservice.protocol.CreateReservationRequest;
import com.awesomeorg.restaurantservice.repository.InternalReservationQuery;
import com.awesomeorg.restaurantservice.repository.ReservationRepository;
import com.awesomeorg.restaurantservice.repository.specification.ReservationSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerService customerService;
    private final TableService tableService;

    public Reservation createReservation(final CreateReservationRequest request,
                                         final Long customerId) {

        final Optional<BlocklistedCustomer> optionalBlocklistedCustomer = customerService.findBlockListedCustomer(customerId);
        if (optionalBlocklistedCustomer.isPresent()) {
            throw new BadRequestException(String.format("Customer %d is blocklisted", customerId));
        }

        final Optional<Table> optionalTable = tableService.findTableById(request.getTableId());
        if (optionalTable.isEmpty()) {
            throw new NotFoundException(String.format("Table %d not found", request.getTableId()));
        }

        final Table table = optionalTable.get();
        if (table.getMaxNumberOfGuests() < request.getNumberOfGuests()) {
            throw new BadRequestException("Table can't fit so many guests");
        }


        final InternalReservationQuery query = new InternalReservationQuery();
        query.setCustomerId(customerId);
        query.setReservationDate(request.getReservationDate());

        final Page<Reservation> reservations = findReservations(query, PageRequest.of(0, 1));
        if (!reservations.isEmpty()) {
            throw new BadRequestException(String.format("Customer %d already has a reservation for the %s",
                    customerId,
                    request.getReservationDate()));
        }

        final Reservation reservation = new Reservation(request, customerId);

        return reservationRepository.save(reservation);
    }

    public Page<Reservation> findReservations(final InternalReservationQuery query,
                                              final Pageable pageRequest) {
        final Specification<Reservation> specification = ReservationSpecification.createSpecification(query);
        return reservationRepository.findAll(specification, pageRequest);
    }
}
