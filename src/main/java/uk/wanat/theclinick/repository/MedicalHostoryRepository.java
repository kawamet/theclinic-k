package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.wanat.theclinick.model.MedicalHistory;

public interface MedicalHostoryRepository extends JpaRepository<MedicalHistory, Long> {
}
