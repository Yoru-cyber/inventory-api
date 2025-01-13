package io.github.yorucyber.inventory_api.dto;

import io.github.yorucyber.inventory_api.entities.Provider;

public record ProviderDTO(long id, String name) {
    // Convert ProviderDTO to Provider Entity
    public static Provider toEntity(ProviderDTO providerDTO) {
      return Provider.builder().id(providerDTO.id).name(providerDTO.name).build();
    }
    // Convert Provider Entity to ProviderDTO
    public static ProviderDTO toDTO(Provider provider) {
        return new ProviderDTO(provider.getId(), provider.getName());

    }
}
