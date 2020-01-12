package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.Patient;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
     Patient findFirstById(Long id);

}
