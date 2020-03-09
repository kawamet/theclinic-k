package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.wanat.theclinick.model.AppointmentDetails;
@Repository
public interface AppointmentDetailsReposotory extends JpaRepository<AppointmentDetails, Long> {
    AppointmentDetails findFirstById(Long id);
}
