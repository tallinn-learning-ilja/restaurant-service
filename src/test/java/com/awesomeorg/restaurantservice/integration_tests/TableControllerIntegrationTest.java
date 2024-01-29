package com.awesomeorg.restaurantservice.integration_tests;

import com.awesomeorg.restaurantservice.AbstractIntegrationTest;
import com.awesomeorg.restaurantservice.entity.Table;
import com.awesomeorg.restaurantservice.util.TestPageImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class TableControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String BASE_PATH = "/tables";

    @Test
    @SneakyThrows
    void test() {
        final MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH))
                .andExpect(status().isOk())
                .andReturn();

        final String jsonString = result.getResponse().getContentAsString();

        final Page<Table> tables = mapper.readValue(jsonString, new TypeReference<TestPageImpl<Table>>() {});

        assertThat(tables.getTotalElements()).isEqualTo(10);
        assertThat(tables.isFirst()).isTrue();
        assertThat(tables.isLast()).isTrue();
    }
}
