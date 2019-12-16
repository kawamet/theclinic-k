package uk.wanat.theclinick.service;

import uk.wanat.theclinick.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Optional<Doctor> findById(Long patientId);

    Doctor findFirstById(Long id);

    List<Doctor> findAll();

    Doctor create(Doctor patient);

    Doctor update(Long patientId, Doctor patient);

    void deleteById(Long appointmentId);
}
