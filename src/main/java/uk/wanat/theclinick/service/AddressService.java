package uk.wanat.theclinick.service;

import uk.wanat.theclinick.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService extends CrudService<Address, Long> {

    Optional<Address> findById(Long id);

    Address findFirstById(Long id);

    List<Address> findAll();

    Address create(Address address);

    Address update(Long id, Address address);

    void deleteById(Long id);

}
