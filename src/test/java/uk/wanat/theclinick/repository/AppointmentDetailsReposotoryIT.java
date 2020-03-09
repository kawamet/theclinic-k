package uk.wanat.theclinick.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import uk.wanat.theclinick.model.AppointmentDetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class AppointmentDetailsReposotoryIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentDetailsReposotory appointmentDetailsReposotory;

    @Test
    void whenfindFirstById_thenReturnAppointmentDetails() {
        //given
        AppointmentDetails appointmentDetailsBuilder = AppointmentDetails.builder().medicine("paracetamol").build();
        entityManager.persist(appointmentDetailsBuilder);
        entityManager.flush();

        //when
        AppointmentDetails appontmentExpected = appointmentDetailsReposotory.findFirstById(1L);

        //than
        assertThat(appontmentExpected).isEqualTo(appointmentDetailsBuilder);
        assertThat(appontmentExpected.getMedicine()).isEqualTo(appointmentDetailsBuilder.getMedicine());

    }
}