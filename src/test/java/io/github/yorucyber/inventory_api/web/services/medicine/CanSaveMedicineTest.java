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

@ExtendWith(SpringExtension.class)
public class CanSaveMedicineTest {
    @Autowired
    private MedicineService medicineService;
    @MockitoBean
    private IMedicineRepository medicineRepository;

    @Test
    void saveShouldSaveEntity() throws Exception {
        Medicine newMedicine = new Medicine();
        newMedicine.setStock(200);
        newMedicine.setName("Acetaminofen");
        Mockito.when(medicineService.save(newMedicine)).thenReturn(newMedicine);
    }

    @TestConfiguration
    static class MedicineServiceTestContextConfiguration {

        @Bean
        public MedicineService medicineService() {
            return new MedicineService();
        }
    }
}
