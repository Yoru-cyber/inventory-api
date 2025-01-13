package io.github.yorucyber.inventory_api.controllers;

import io.github.yorucyber.inventory_api.dto.SaleDTO;
import io.github.yorucyber.inventory_api.services.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SaleController {
    private final SaleService saleService;
    Logger logger = LoggerFactory.getLogger(SaleController.class);

    SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/api/v1/sales")
    public List<SaleDTO> all() {
        return saleService.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("api/v1/sales")
    public SaleDTO create(@RequestBody SaleDTO saleDTO) {
        return saleService.save(saleDTO);
    }

    // Returns a single item
    //Needs error handle when entity doesn't exist
    @GetMapping("/api/v1/sales/{id}")
    public SaleDTO find(@PathVariable Long id) {
        try {
            return saleService.findById(id);
        } catch (Exception e) {
            logger.error("Error retrieving medicine", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sale not found", e);
        }

    }

    @PutMapping("/api/v1/sales/{id}")
    public SaleDTO update(@RequestBody SaleDTO saleDTO, @PathVariable Long medicineId) {
        try {
            return saleService.update(medicineId, saleDTO);
        } catch (Exception e) {
            logger.error("Error retrieving sale", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sale not found", e);
        }
    }

    @DeleteMapping("/api/v1/sales/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        saleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
