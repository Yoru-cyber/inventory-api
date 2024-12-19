package io.github.yorucyber.inventory_api.services;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.repositories.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    private final IMedicineRepository medicineRepository;

    @Autowired
    public MedicineService(IMedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAllMedicines() {
        return (List<Medicine>) medicineRepository.findAll();
    }

    public Medicine getMedicineById(long id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        return medicine.orElseThrow(() -> new IllegalArgumentException("Medicine not found with id: " + id));
    }

    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine update(long id, Medicine updatedMedicine) {
        Medicine existingMedicine = medicineRepository.findById(id).orElse(null);
        existingMedicine. setName(updatedMedicine.getName());
        existingMedicine.setPrice(updatedMedicine.getPrice());
        existingMedicine.setStock(updatedMedicine.getStock());
        medicineRepository.save(existingMedicine);
        return  existingMedicine;
    }

    public void deleteMedicineById(long id) {
        medicineRepository.deleteById(id);
    }
}
