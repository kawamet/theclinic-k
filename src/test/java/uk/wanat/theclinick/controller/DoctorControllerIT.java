package uk.wanat.theclinick.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.service.DoctorServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DoctorControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorServiceImpl doctorService;


    @Test
    void putAddDoctorReturnsHttpStatusOk() throws Exception {
        //given
        Doctor doctorBuilder = Doctor.builder().firstName("Will").build();
        //when
        when(doctorService.create(doctorBuilder)).thenReturn(expectedAddress());

        mockMvc.perform(
                put("/doctor/addDoctor")
                        .requestAttr("doctor", doctorBuilder))
                .andExpect(status().isOk());
    }

    private Doctor expectedAddress() {
        return Doctor.builder().firstName("Will").build();
    }

}