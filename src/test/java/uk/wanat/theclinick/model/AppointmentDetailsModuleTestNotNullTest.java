package uk.wanat.theclinick.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.wanat.theclinick.controller.AppointmentDetailsController;
import uk.wanat.theclinick.repository.AppointmentDetailsReposotory;
import uk.wanat.theclinick.service.AppointmentDetailsServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppointmentDetailsModuleTestNotNullTest {

    @Autowired
    AppointmentDetailsReposotory appointmentDetailsReposotory;
    @Autowired
    AppointmentDetailsServiceImpl appointmentDetailsService;
    @Autowired
    AppointmentDetailsController appointmentDetailsController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(appointmentDetailsReposotory).isNotNull();
        assertThat(appointmentDetailsService).isNotNull();
        assertThat(appointmentDetailsController).isNotNull();
    }

}