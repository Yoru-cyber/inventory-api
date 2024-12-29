package io.github.yorucyber.inventory_api.web.services.medicine;

import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.repositories.IMedicineRepository;
import io.github.yorucyber.inventory_api.services.MedicineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CanDeleteMedicineTest {
    @Autowired
    private MedicineService medicineService;

    @MockitoBean
    private IMedicineRepository medicineRepository;

    @Test
    void saveShouldSaveEntity() throws Exception {
        // Arrange
        Medicine newMedicine = Medicine.builder().stock(200).price(BigDecimal.valueOf(34.64)).name("Acetaminofen").build();

        when(medicineRepository.save(Mockito.any(Medicine.class))).thenReturn(newMedicine);
        when(medicineRepository.findById(1L)).thenReturn(Optional.of(newMedicine));

        // Act
        Medicine savedMedicine = medicineService.save(newMedicine);
        Medicine foundMedicine = medicineService.findById(1);

        // Assert
        assertNotNull(savedMedicine);
        assertEquals("Acetaminofen", foundMedicine.getName());
    }

    @TestConfiguration
    static class MedicineServiceTestContextConfiguration {

        @Bean
        public MedicineService medicineService(IMedicineRepository medicineRepository) {
            return new MedicineService();
        }
    }
}