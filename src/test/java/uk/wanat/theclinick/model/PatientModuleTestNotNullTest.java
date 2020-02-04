package uk.wanat.theclinick.model;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.wanat.theclinick.controller.AddressController;
import uk.wanat.theclinick.controller.PatientController;
import uk.wanat.theclinick.repository.AddressRepository;
import uk.wanat.theclinick.repository.PatientRepository;
import uk.wanat.theclinick.service.AddressServiceImpl;
import uk.wanat.theclinick.service.PatientServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PatientModuleTestNotNullTest {

    @Autowired(required = false)
    private PatientController patientController;
    @Autowired(required = false)
    private PatientServiceImpl patientService;
    @Autowired(required = false)
    private PatientRepository patientRepository;


    @Test
    public void contexLoads() throws Exception {
        assertThat(patientController).isNotNull();
        assertThat(patientService).isNotNull();
        assertThat(patientRepository).isNotNull();
    }





}