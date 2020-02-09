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
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.service.DoctorServiceImpl;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DoctorControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private DoctorServiceImpl doctorService;


    @BeforeEach
    void printApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);
    }

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