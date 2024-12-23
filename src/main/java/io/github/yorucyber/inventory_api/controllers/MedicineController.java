package io.github.yorucyber.inventory_api.controllers;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.services.MedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicineController {

    private final MedicineService medicineService;

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
        return medicineService.findById(id);
    }

    @PutMapping("/api/v1/medicines/{id}")
    public Medicine update(@RequestBody Medicine updatedMedicine, @PathVariable Long id) {
        Medicine existingMedicine = medicineService.findById(id);
        existingMedicine.setName(updatedMedicine.getName());
        existingMedicine.setPrice(updatedMedicine.getPrice());
        existingMedicine.setStock(updatedMedicine.getStock());
        return medicineService.update(id, existingMedicine);
    }

    @DeleteMapping("/api/v1/medicines/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        medicineService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
