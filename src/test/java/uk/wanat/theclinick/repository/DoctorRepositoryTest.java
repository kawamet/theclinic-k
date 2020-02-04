package uk.wanat.theclinick.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.model.Speciality;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class DoctorRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    DoctorRepository doctorRepository;

    @Test
    void whenfindFirstById_thenReturnDoctor() {
        //given
        Doctor doctorBuilder = Doctor.builder().firstName("Will").build();
        testEntityManager.persist(doctorBuilder);
        testEntityManager.flush();

        Doctor doctorExpected = doctorRepository.findFirstById(1L);

        assertThat(doctorExpected).isEqualTo(doctorBuilder);
    }


    @Test
    void whenfindAllBySpeciality_thenReturnDoctorList() {
        testEntityManager.persist(Doctor.builder().speciality(Speciality.DENTISTRY).build());
        testEntityManager.persist(Doctor.builder().speciality(Speciality.CARDIOLOGY).build());
        testEntityManager.persist(Doctor.builder().speciality(Speciality.DENTISTRY).build());
        testEntityManager.flush();

        List<Doctor> allBySpeciality = doctorRepository.findAllBySpeciality(Speciality.DENTISTRY);

        assertThat(allBySpeciality.size()).isEqualTo(2);

    }
}