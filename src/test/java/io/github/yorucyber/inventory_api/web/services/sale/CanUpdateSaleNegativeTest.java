package io.github.yorucyber.inventory_api.web.services.sale;

import io.github.yorucyber.inventory_api.repositories.IMedicineRepository;
import io.github.yorucyber.inventory_api.repositories.ISaleRepository;
import io.github.yorucyber.inventory_api.services.SaleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CanUpdateSaleNegativeTest {
    @Mock
    private ISaleRepository saleRepository;

    @Mock
    private IMedicineRepository medicineRepository;

    @InjectMocks
    private SaleService saleService;

    @Test
    public void updateShouldThrowExceptionWhenSaleNotFound() {
        // Arrange
//        long id = 2L;
//        Medicine medicine = Medicine.builder().id(1L).stock(100).price(BigDecimal.valueOf(34.64)).name("Acetaminofen").build();
//
//        // Create a Provider
//        Provider provider = Provider.builder().id(1L).name("PharmaCorp").build();
//
//        // Create a Sale with a quantity of 200
//        Sale updatedSale = Sale.builder().price(BigDecimal.valueOf(10.99)).stock(200).medicine(medicine).provider(provider).build();
//        when(saleRepository.findById(id)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        assertThrows(SaleNotFoundException.class, () -> saleService.update(id, updatedSale), "update should throw SaleNotFoundException when sale is not found");
//        verify(saleRepository, times(1)).findById(id);
//        verify(medicineRepository, never()).save(any(Medicine.class));
//        verify(saleRepository, never()).save(any(Sale.class));
    }

}
