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
import uk.wanat.theclinick.model.AppointmentDetails;
import uk.wanat.theclinick.service.AppointmentDetailsServiceImpl;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AppointmentDetailsControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentDetailsServiceImpl appointmentDetailsService;


    @Test
    void putAddAppointmentDetailsReturnsHttpStatusOk() throws Exception {
        //given
        AppointmentDetails appointmentDetailsBuilder = AppointmentDetails.builder().medicine("paracetamol").build();
        //when
        when(appointmentDetailsService.create(appointmentDetailsBuilder)).thenReturn(expectedAddress());

        mockMvc.perform(
                put("/appointmentdetails/{id}/addDetails", "1")
                        .sessionAttr("appointmentdetails", appointmentDetailsBuilder))
                .andExpect(status().isOk());
    }

    private AppointmentDetails expectedAddress() {
        return AppointmentDetails.builder().medicine("paracetamol").build();
    }

}