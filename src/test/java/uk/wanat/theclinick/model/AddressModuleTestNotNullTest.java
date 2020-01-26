package uk.wanat.theclinick.model;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.wanat.theclinick.controller.AddressController;
import uk.wanat.theclinick.repository.AddressRepository;
import uk.wanat.theclinick.service.AddressServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class AddressModuleTestNotNullTest {

    @Autowired(required = false)
    private AddressController addressController;
    @Autowired(required = false)
    private AddressServiceImpl addressServiceImpl;
    @Autowired(required = false)
    private AddressRepository addressRepository;


    @Test
    public void contexLoads() throws Exception {
        assertThat(addressController).isNotNull();
        assertThat(addressServiceImpl).isNotNull();
        assertThat(addressRepository).isNotNull();
    }





}