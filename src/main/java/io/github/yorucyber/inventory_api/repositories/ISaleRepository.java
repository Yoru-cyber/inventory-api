package io.github.yorucyber.inventory_api.repositories;

import io.github.yorucyber.inventory_api.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
}
