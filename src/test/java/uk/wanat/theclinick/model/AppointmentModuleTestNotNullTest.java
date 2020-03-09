package uk.wanat.theclinick.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.wanat.theclinick.controller.AppointmentController;
import uk.wanat.theclinick.repository.AppointmentRepository;
import uk.wanat.theclinick.service.AppointmentServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppointmentModuleTestNotNullTest {

    @Autowired(required = false)
    private AppointmentController appointmentController;
    @Autowired(required = false)
    private AppointmentServiceImpl appointmentService;
    @Autowired(required = false)
    private AppointmentRepository appointmentRepository;

    @Test
    public void contexLoads() throws Exception {
        assertThat(appointmentController).isNotNull();
        assertThat(appointmentService).isNotNull();
        assertThat(appointmentRepository).isNotNull();
    }
}