package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.wanat.theclinick.model.AppointmentDetails;

public interface AppointmentDetailsReposotory extends JpaRepository<AppointmentDetails, Long> {
    AppointmentDetails findFirstById(Long id);
}
