package io.github.yorucyber.inventory_api.dto;

import java.math.BigDecimal;

public record MedicineDTO(String name, BigDecimal price, int stock, String provider) {
}
