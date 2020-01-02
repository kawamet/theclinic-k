package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.model.Speciality;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
     Doctor findFirstById(Long id);
     List<Doctor> findAllBySpeciality(Speciality speciality);

}
