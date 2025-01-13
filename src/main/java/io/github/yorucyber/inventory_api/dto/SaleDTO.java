package io.github.yorucyber.inventory_api.dto;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.entities.Provider;
import io.github.yorucyber.inventory_api.entities.Sale;

import java.math.BigDecimal;

public record SaleDTO(long id, BigDecimal price, Integer stock, long medicineId, long providerId) {
    public static Sale toEntity(SaleDTO saleDTO, Medicine medicine, Provider provider) {
        return new Sale(saleDTO.id, saleDTO.price, saleDTO.stock, medicine, provider);
    }

    public static SaleDTO toDTO(Sale sale) {
        return new SaleDTO(sale.getId(), sale.getPrice(), sale.getStock(), sale.getMedicine().getId(), sale.getProvider().getId());
    }
}
