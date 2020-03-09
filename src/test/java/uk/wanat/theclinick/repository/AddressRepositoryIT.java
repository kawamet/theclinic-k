package uk.wanat.theclinick.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.model.Doctor;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
class AddressRepositoryIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void whenfindFirstById_thenReturnAddress() {
        //given
        Address addressBuilder = Address.builder().street("20 Deans Yd").city("London").postcode("SW1P 3PA").build();
        entityManager.persist(addressBuilder);
        entityManager.flush();

        //when
        Address addressRepositoryFirstById = addressRepository.findFirstById(1L);

        //than
        assertThat(addressBuilder).isEqualTo(addressRepositoryFirstById);

    }

}