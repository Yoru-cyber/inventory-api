package io.github.yorucyber.inventory_api.repositories;

import io.github.yorucyber.inventory_api.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<Purchase, Long> {
}
