package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.wanat.theclinick.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
