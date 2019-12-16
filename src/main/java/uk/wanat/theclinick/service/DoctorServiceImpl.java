package uk.wanat.theclinick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Component("doctorservice")
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Optional<Doctor> findById(Long patientId) {
        return doctorRepository.findById(patientId);
    }

    @Override
    public Doctor findFirstById(Long id) {
        return doctorRepository.findFirstById(id);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Long doctorId, Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteById(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
