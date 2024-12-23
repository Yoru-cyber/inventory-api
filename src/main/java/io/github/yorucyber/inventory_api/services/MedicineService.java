package io.github.yorucyber.inventory_api.services;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.exceptions.MedicineNotFoundException;
import io.github.yorucyber.inventory_api.repositories.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private IMedicineRepository medicineRepository;


    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    public Medicine findById(long id) {
        return medicineRepository.findById(id).orElseThrow(() -> new MedicineNotFoundException("Medicine not found with id: " + id, id));
    }

    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine update(long id, Medicine updatedMedicine) {
        Medicine existingMedicine = medicineRepository.findById(id).orElseThrow(() -> new MedicineNotFoundException("Medicine not found with id: " + id, id));
        existingMedicine.setName(updatedMedicine.getName());
        existingMedicine.setPrice(updatedMedicine.getPrice());
        existingMedicine.setStock(updatedMedicine.getStock());
        medicineRepository.save(existingMedicine);
        return existingMedicine;
    }

    public void deleteById(long id) {
        medicineRepository.deleteById(id);
    }
}
