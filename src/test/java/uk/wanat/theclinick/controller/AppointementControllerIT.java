package uk.wanat.theclinick.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.ExaminationRoom;
import uk.wanat.theclinick.model.Speciality;
import uk.wanat.theclinick.service.AppointmentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AppointementControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AppointmentServiceImpl appointmentService;


    @BeforeEach
    void printApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void displaySpecialitiesReturnsHttpStatusOk() throws Exception {
        //given
        List<Speciality> enums = Arrays.asList(Speciality.values());

        mockMvc.perform(
                put("/appointment/chooseSpeciality")
                        .sessionAttr("speciality", enums))
                .andExpect(status().isOk());
    }


    @Test
    void deleteAppointment_than_returnsHttpStatusOk() throws Exception {
        Appointment appointment = Appointment.builder().id(1L).examinationRoom(ExaminationRoom.A2).build();
        when(appointmentService.findFirstById(appointment.getId())).thenReturn(appointment);
        doNothing().when(appointmentService).deleteById(appointment.getId());
        mockMvc.perform(
                delete("/appointment/{id}/delete", "1").param("id", "1"))
                .andExpect(redirectedUrl("/showAllapointments"));

        verify(appointmentService, times(1)).deleteById(appointment.getId());
        verifyNoMoreInteractions(appointmentService);

    }
    @Test
    void showAllAppointmentsReturnsHttpStatusOk() throws Exception {
        //given
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(Appointment.builder().id(1L).build());
        appointmentList.add(Appointment.builder().id(2L).build());


        mockMvc.perform(
                put("/showAllapointments")
                        .requestAttr("appointmentList", appointmentList))
                .andExpect(status().isOk());
    }

}