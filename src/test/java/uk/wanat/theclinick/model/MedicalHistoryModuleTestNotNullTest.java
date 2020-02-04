package uk.wanat.theclinick.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.wanat.theclinick.controller.MedicalHistoryController;
import uk.wanat.theclinick.repository.MedicalHistoryRepository;
import uk.wanat.theclinick.service.MedicalHistoryServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MedicalHistoryModuleTestNotNullTest {

    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;
    @Autowired
    MedicalHistoryServiceImpl medicalHistoryService;
    @Autowired
    MedicalHistoryController medicalHistoryController;

    void contexLoads() throws Exception{
        assertThat(medicalHistoryController).isNotNull();
        assertThat(medicalHistoryService).isNotNull();
        assertThat(medicalHistoryController).isNotNull();
    }

}