package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.wanat.theclinick.model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
