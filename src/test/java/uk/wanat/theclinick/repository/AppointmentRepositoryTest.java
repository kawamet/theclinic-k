package uk.wanat.theclinick.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.model.ExaminationRoom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class AppointmentRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Test
    void whenfindFirstById_thenReturnAppointment() {
        //given
        Appointment appointmentBuilder = Appointment.builder().examinationRoom(ExaminationRoom.A2).build();
        appointmentBuilder.setDoctor(Doctor.builder().firstName("karol").build());
        testEntityManager.persist(appointmentBuilder);
        testEntityManager.flush();

        //when
        Appointment appointmentExcepted = appointmentRepository.findFirstById(1L);

        //than
        assertThat(appointmentExcepted).isEqualTo(appointmentBuilder);
        assertThat(appointmentExcepted.getDoctor()).isEqualTo(appointmentBuilder.getDoctor());

    }
}