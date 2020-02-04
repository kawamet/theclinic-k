package uk.wanat.theclinick.service;


import uk.wanat.theclinick.model.MedicalHistory;

import java.util.List;
import java.util.Optional;

public interface MedicalHistoryService extends CrudService<MedicalHistory, Long> {

    Optional<MedicalHistory> findById(Long id);

    MedicalHistory findFirstById(Long id);

    List<MedicalHistory> findAll();

    MedicalHistory create(MedicalHistory address);

    MedicalHistory update(Long id, MedicalHistory address);

    void deleteById(Long id);
}
