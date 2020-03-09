package uk.wanat.theclinick.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.service.PatientServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientServiceImpl patientService;


    @Test
    void putAddPatientReturnsHttpStatusOk() throws Exception {
        //given
        Patient patientBuilder = Patient.builder().firstName("Will").lastName("Smith").build();
        //when
        when(patientService.create(patientBuilder)).thenReturn(expectedPatient());

        mockMvc.perform(
                put("/patient/addPatient")
                        .requestAttr("patient", patientBuilder))
                .andExpect(status().isOk());
    }

    private Patient expectedPatient() {
        Patient patient = Patient.builder().firstName("Will").lastName("Smith").build();
        return patient;
    }

}