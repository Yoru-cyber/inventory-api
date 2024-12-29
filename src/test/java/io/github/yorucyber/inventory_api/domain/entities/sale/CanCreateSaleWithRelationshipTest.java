package io.github.yorucyber.inventory_api.domain.entities.sale;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.entities.Provider;
import io.github.yorucyber.inventory_api.entities.Sale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class CanCreateSaleWithRelationshipTest {

    @Test
    void shouldCreateEntitiesWithRelationship() throws Exception {
        Medicine medicine = Medicine.builder().id(1L).stock(200).price(BigDecimal.valueOf(34.64)).name("Acetaminofen").build();
        Provider provider = Provider.builder().id(1L).name("PharmaCorp").build();
        Sale sale = Sale.builder().provider(provider).medicine(medicine).price(BigDecimal.valueOf(10.99)).stock(200).build();
        medicine.setSales(List.of(sale));
        provider.setSales(List.of(sale));

        assertNotNull(medicine.getSales());
        assertEquals(1, medicine.getSales().size());
        assertEquals(sale, medicine.getSales().get(0));

        assertNotNull(provider.getSales());
        assertEquals(1, provider.getSales().size());
        assertEquals(sale, provider.getSales().get(0));
        assertNotNull(sale.getProvider());
        assertNotNull(sale.getMedicine());

    }

}
