package uk.wanat.theclinick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.wanat.theclinick.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
