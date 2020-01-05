package uk.wanat.theclinick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.wanat.theclinick.model.MedicalHistory;
import uk.wanat.theclinick.repository.MedicalHistoryRepository;

import java.util.List;
import java.util.Optional;

@Component("medicalhistoryservice")
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public Optional<MedicalHistory> findById(Long id) {
        return medicalHistoryRepository.findById(id);
    }

    @Override
    public MedicalHistory findFirstById(Long id) {
        return medicalHistoryRepository.findFirstById(id);
    }

    @Override
    public List<MedicalHistory> findAll() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public MedicalHistory create(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public MedicalHistory update(Long id, MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public void deleteById(Long id) {
        medicalHistoryRepository.deleteById(id);
    }
}
