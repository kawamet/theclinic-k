package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.wanat.theclinick.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
     Doctor findFirstById(Long id);

}
