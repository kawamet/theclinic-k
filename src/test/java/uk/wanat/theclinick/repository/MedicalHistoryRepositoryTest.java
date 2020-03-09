package uk.wanat.theclinick.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import uk.wanat.theclinick.model.MedicalHistory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
class MedicalHistoryRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;

    @Test
    void whenfindFirstById_thenReturnMedicalHistory() {
        MedicalHistory medicalHistoryBuilder = MedicalHistory.builder().diabetes(false).build();
        testEntityManager.persist(medicalHistoryBuilder);
        testEntityManager.flush();

        MedicalHistory medicalHistoryExpected = medicalHistoryRepository.findFirstById(1L);

        assertThat(medicalHistoryExpected).isEqualTo(medicalHistoryBuilder);

    }
}