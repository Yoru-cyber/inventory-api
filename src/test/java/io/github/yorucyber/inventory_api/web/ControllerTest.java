package io.github.yorucyber.inventory_api.web;

import io.github.yorucyber.inventory_api.controllers.MedicineController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ControllerTest {

    @Autowired
    private MedicineController medicineController;

    @Test
    void contextLoads() throws Exception {
        assertThat(medicineController).isNotNull();
    }
}
