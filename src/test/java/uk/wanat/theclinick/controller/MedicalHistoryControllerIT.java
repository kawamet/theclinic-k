package uk.wanat.theclinick.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.model.MedicalHistory;
import uk.wanat.theclinick.service.MedicalHistoryServiceImpl;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class MedicalHistoryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private MedicalHistoryServiceImpl medicalHistoryService;


    @BeforeEach
    void printApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void putAddMedicalHistoryReturnsHttpStatusOk() throws Exception {
        //given
        MedicalHistory medicalHistoryBuilder = MedicalHistory.builder().allergy("nuts").build();
        //when
        when(medicalHistoryService.create(medicalHistoryBuilder)).thenReturn(expectedMedicalHistory());

        mockMvc.perform(
                put("/medicalHistory/addMedicalHistory")
                        .sessionAttr("medicalHistory", medicalHistoryBuilder))
                .andExpect(status().isOk());
    }

    private MedicalHistory expectedMedicalHistory() {
        return MedicalHistory.builder().allergy("nuts").build();
    }

}