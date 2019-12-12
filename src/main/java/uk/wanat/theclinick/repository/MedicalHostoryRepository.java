package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.wanat.theclinick.model.MedicalHistory;
@Repository
public interface MedicalHostoryRepository extends JpaRepository<MedicalHistory, Long> {
}
