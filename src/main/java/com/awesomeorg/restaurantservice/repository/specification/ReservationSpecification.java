package com.awesomeorg.restaurantservice.repository.specification;

import com.awesomeorg.restaurantservice.entity.Reservation;
import com.awesomeorg.restaurantservice.repository.InternalReservationQuery;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ReservationSpecification {

    public static Specification<Reservation> createSpecification(final InternalReservationQuery query) {
        Specification<Reservation> specification = null;
        final List<Specification<Reservation>> specifications = getSpecificationList(query);
        for (final Specification<Reservation> s : specifications) {
            if (specification == null) {
                specification = Specification.where(s);
            } else {
                specification = specification.and(s);
            }
        }
        return specification;
    }

    private static List<Specification<Reservation>> getSpecificationList(final InternalReservationQuery query) {
        final List<Specification<Reservation>> specifications = new ArrayList<>();
        if (query.getStatus() != null) {
            Specification<Reservation> specification = Specification
                    .where(withEqualsField(new ReservationSearchCriteria("reservationStatus", query.getStatus())));
            specifications.add(specification);
        }
        if (query.getReservationDate() != null) {
            Specification<Reservation> specification = Specification
                    .where(withEqualsField(new ReservationSearchCriteria("reservationDate", query.getReservationDate())));
            specifications.add(specification);
        }

        if (query.getCustomerId() != null && query.getCustomerId() != 0) {
            Specification<Reservation> specification = Specification
                    .where(withEqualsField(new ReservationSearchCriteria("customerId", query.getCustomerId())));
            specifications.add(specification);
        }

        if (query.getTableId() != null && query.getTableId() != 0) {
            Specification<Reservation> specification = Specification
                    .where(withEqualsField(new ReservationSearchCriteria("tableId", query.getTableId())));
            specifications.add(specification);
        }



        return specifications;
    }

    private static Specification<Reservation> withEqualsField(final ReservationSearchCriteria criteria) {
        return ((root, query, builder) -> builder.equal(root.get(criteria.getKey()), criteria.getValue()));
    }


}
