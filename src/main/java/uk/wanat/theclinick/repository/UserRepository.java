package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.wanat.theclinick.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String emial);
}