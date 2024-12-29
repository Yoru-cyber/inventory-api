package io.github.yorucyber.inventory_api.controllers;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.services.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MedicineController {

    private final MedicineService medicineService;
    Logger logger = LoggerFactory.getLogger(MedicineController.class);

    MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/api/v1/medicines")
    public List<Medicine> all() {
        return medicineService.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/api/v1/medicines")
    public Medicine create(@RequestBody Medicine medicine) {
        return medicineService.save(medicine);
    }

    // Returns a single item
    //Needs error handle when entity doesn't exist
    @GetMapping("/api/v1/medicines/{id}")
    public Medicine find(@PathVariable Long id) {
        try {
            return medicineService.findById(id);
        } catch (Exception e) {
            logger.error("Error retrieving medicine", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found", e);
        }

    }

    @PutMapping("/api/v1/medicines/{id}")
    public Medicine update(@RequestBody Medicine updatedMedicine, @PathVariable Long id) {
        try {
            return medicineService.update(id, updatedMedicine);
        } catch (Exception e) {
            logger.error("Error retrieving medicine", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found", e);
        }
    }

    @DeleteMapping("/api/v1/medicines/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        medicineService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
