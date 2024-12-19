package io.github.yorucyber.inventory_api.repositories;

import io.github.yorucyber.inventory_api.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Long> {

}