package uk.wanat.theclinick.service;

import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.AppointmentDetails;

import java.util.List;
import java.util.Optional;

public interface AppointmentDetailsService {

    Optional<AppointmentDetails> findById(Long id);

    AppointmentDetails findFirstById(Long id);

    List<AppointmentDetails> findAll();

    AppointmentDetails create(AppointmentDetails appointmentDetails);

    AppointmentDetails update(Long id, AppointmentDetails appointmentDetails);

    void deleteById(Long id);

}
