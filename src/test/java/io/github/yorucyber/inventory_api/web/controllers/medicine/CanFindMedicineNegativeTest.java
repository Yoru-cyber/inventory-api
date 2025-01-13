package io.github.yorucyber.inventory_api.web.controllers.medicine;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.yorucyber.inventory_api.controllers.MedicineController;
import io.github.yorucyber.inventory_api.entities.Medicine;
import io.github.yorucyber.inventory_api.exceptions.MedicineNotFoundException;
import io.github.yorucyber.inventory_api.services.MedicineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class CanFindMedicineNegativeTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @Mock
    private MedicineService medicineService;
    @Mock
    private Logger logger;
    @InjectMocks
    private MedicineController medicineController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(medicineController).build();
    }

    @Test
    public void testUpdateMedicine_NotFound() throws Exception {
        long id = 1L;
        Medicine updatedMedicine = Medicine.builder().id(1L).stock(200).name("Acetaminofen").build();
        String json = objectMapper.writeValueAsString(updatedMedicine);
        when(medicineService.update(eq(id), any(Medicine.class))).thenThrow(new MedicineNotFoundException("Medicine not found with id: " + id, id));

        mockMvc.perform(put("/api/v1/medicines/{id}", id).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedMedicine))).andExpect(status().isNotFound());
    }
}
