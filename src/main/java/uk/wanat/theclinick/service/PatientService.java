package uk.wanat.theclinick.service;

import uk.wanat.theclinick.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Optional<Patient> findById(Long patientId);

    Patient findFirstById(Long id);

    List<Patient> findAll();

    Patient create(Patient patient);

    Patient update(Long patientId, Patient patient);

    void deleteById(Long appointmentId);
}
