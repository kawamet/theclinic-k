package uk.wanat.theclinick.service;

import uk.wanat.theclinick.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Optional<Appointment> findById(Long id);

    Appointment findFirstById(Long id);

    List<Appointment> findAll();

    Appointment create(Appointment appointment);

    Appointment update(Long id, Appointment appointment);

    void deleteById(Long id);

}
