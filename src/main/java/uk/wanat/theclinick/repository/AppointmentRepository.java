package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.wanat.theclinick.model.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
