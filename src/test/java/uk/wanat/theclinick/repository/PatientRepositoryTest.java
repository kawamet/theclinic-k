package uk.wanat.theclinick.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import uk.wanat.theclinick.model.Patient;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@RunWith(SpringRunner.class)
class PatientRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PatientRepository patientRepository;

    @Test
    void whenfindFirstById_thenReturnPatient() {
        Patient patientBuilder = Patient.builder().firstName("Scarlett").build();
        testEntityManager.persist(patientBuilder);
        testEntityManager.flush();

        Patient patientExpected = patientRepository.findFirstById(1L);

        assertThat(patientExpected).isEqualTo(patientBuilder);

    }
}