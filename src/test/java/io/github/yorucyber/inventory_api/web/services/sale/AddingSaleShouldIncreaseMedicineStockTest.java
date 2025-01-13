package io.github.yorucyber.inventory_api.web.services.sale;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.entities.Provider;
import io.github.yorucyber.inventory_api.entities.Sale;
import io.github.yorucyber.inventory_api.repositories.IMedicineRepository;
import io.github.yorucyber.inventory_api.repositories.ISaleRepository;
import io.github.yorucyber.inventory_api.services.SaleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class AddingSaleShouldIncreaseMedicineStockTest {
    @Mock
    private ISaleRepository saleRepository;

    @Mock
    private IMedicineRepository medicineRepository;

    @InjectMocks
    private SaleService saleService;

    @Test
    public void testAddSale_UpdatesMedicineStockCorrectly() {
        // Arrange
        // Create a Medicine with an initial stock of 200
        Medicine medicine = Medicine.builder().id(1L).stock(200).name("Acetaminofen").build();

        // Create a Provider
        Provider provider = Provider.builder().id(1L).name("PharmaCorp").build();

        // Create a Sale with a quantity of 200
        Sale sale = Sale.builder().price(BigDecimal.valueOf(10.99)).stock(200).medicine(medicine).provider(provider).build();

        // Mock the repositories
        when(medicineRepository.save(medicine)).thenReturn(medicine);
        when(saleRepository.save(sale)).thenReturn(sale);

        // Act
        Sale newSale = saleService.save(sale, 1L);
        // Verify that the repositories were called
        verify(medicineRepository, times(1)).save(medicine);
        verify(saleRepository, times(1)).save(sale);
        // Assert
        // Verify that the medicine's stock is updated to 0
        assertEquals(0, medicine.getStock(), "Medicine stock should be updated to 0");


    }
}
