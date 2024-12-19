package io.github.yorucyber.inventory_api.web;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.yorucyber.inventory_api.controllers.MedicineController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ControllerTest {

    @Autowired
    private MedicineController medicineController;

    @Test
    void contextLoads() throws Exception {
        assertThat(medicineController).isNotNull();
    }
}