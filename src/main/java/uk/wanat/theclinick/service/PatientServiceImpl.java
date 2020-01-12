package uk.wanat.theclinick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Component("patientservice")
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public Optional<Patient> findById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public Patient findFirstById(Long id) {
        return patientRepository.findFirstById(id);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Long patientId, Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleteById(Long appointmentId) {
        patientRepository.deleteById(appointmentId);
    }
}
