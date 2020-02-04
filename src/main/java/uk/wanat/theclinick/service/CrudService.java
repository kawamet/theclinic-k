package uk.wanat.theclinick.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    Optional<T> findById(Long id);

    T findFirstById(ID id);

    List<T> findAll();

    T create(T object);

    T update(ID id, T object);

    void deleteById(ID id);

}
