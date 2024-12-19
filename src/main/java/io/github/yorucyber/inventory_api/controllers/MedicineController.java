package io.github.yorucyber.inventory_api.controllers;

import io.github.yorucyber.inventory_api.dao.MedicineDAO;
import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.exceptions.MedicineNotFoundException;
import io.github.yorucyber.inventory_api.repositories.IMedicineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicineController {
    private final IMedicineRepository medicineRepository;

    MedicineController(IMedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/medicines")
    List<Medicine> all() {
        return medicineRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/medicines")
    Medicine create(@RequestBody Medicine medicineDAO) {
        return medicineRepository.save(medicineDAO);
    }

    // Single item
    @GetMapping("/medicines/{id}")
    Medicine find(@PathVariable Long id) {

        return medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException("Customer does not exist", id));
    }

//    @PutMapping("/medicines/{id}")
//    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return medicineRepository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    return repository.save(newEmployee);
//                });
//    }

    @DeleteMapping("/medicines/{id}")
    void delete(@PathVariable Long id) {
        medicineRepository.deleteById(id);
    }
}
