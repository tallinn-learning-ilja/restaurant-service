package com.awesomeorg.restaurantservice.controller;

import com.awesomeorg.restaurantservice.entity.Table;
import com.awesomeorg.restaurantservice.protocol.TableQuery;
import com.awesomeorg.restaurantservice.service.TableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Table controller", description = "Public endpoints related to tables")
@RestController
@RequestMapping("/tables")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping
    @Operation(summary = "Get all free tables for the given date")
    @ApiResponse(description = "Find all free tables", content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Table.class)))})
    public ResponseEntity<Page<Table>> findTables(@Valid final TableQuery query,
                                                  @RequestParam(defaultValue = "0", required = false) final int pageNumber,
                                                  @RequestParam(defaultValue = "25", required = false) final int pageSize) {

        final Page<Table> tables = tableService.findFreeTables(query, PageRequest.of(pageNumber, pageSize));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tables);

    }
}
