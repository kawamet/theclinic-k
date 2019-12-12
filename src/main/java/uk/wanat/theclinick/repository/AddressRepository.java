package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.wanat.theclinick.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
