package io.github.yorucyber.inventory_api.dao;

import java.math.BigDecimal;

public record MedicineDAO(String name, BigDecimal price, int stock, String provider) {
}
