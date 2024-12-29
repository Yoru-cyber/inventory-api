package io.github.yorucyber.inventory_api.repositories;

import io.github.yorucyber.inventory_api.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProviderRepository extends JpaRepository<Provider, Long> {
}
