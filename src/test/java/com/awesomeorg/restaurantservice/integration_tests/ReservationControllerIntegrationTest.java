package com.awesomeorg.restaurantservice.integration_tests;

import com.awesomeorg.restaurantservice.AbstractIntegrationTest;
import com.awesomeorg.restaurantservice.entity.Reservation;
import com.awesomeorg.restaurantservice.protocol.CreateReservationRequest;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static com.awesomeorg.restaurantservice.util.HeaderConstants.CUSTOMER_ID_HEADER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ReservationControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String BASE_PATH = "/reservations";

    @Test
    @SneakyThrows
    void test() {
        mapper.registerModule(new JavaTimeModule());
        final CreateReservationRequest request = new CreateReservationRequest();
        request.setReservationDate(LocalDate.now());
        request.setTableId(2L);
        request.setNumberOfGuests(5);

        final String content = mapper.writeValueAsString(request);

        final MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_PATH)
                        .header(CUSTOMER_ID_HEADER, 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isCreated())
                .andReturn();

        final String jsonString = result.getResponse().getContentAsString();

        final Reservation reservation = mapper.readValue(jsonString, Reservation.class);

        assertThat(reservation.getReservationStatus()).isEqualTo(Reservation.Status.PENDING);
    }

    @Test
    @SneakyThrows
    void test_missingHeader() {
        mapper.registerModule(new JavaTimeModule());
        final CreateReservationRequest request = new CreateReservationRequest();
        request.setReservationDate(LocalDate.now());
        request.setTableId(2L);
        request.setNumberOfGuests(5);

        final String content = mapper.writeValueAsString(request);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isBadRequest())
                .andReturn();

    }
}
