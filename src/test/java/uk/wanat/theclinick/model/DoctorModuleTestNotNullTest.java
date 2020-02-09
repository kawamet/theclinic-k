package uk.wanat.theclinick.model;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.wanat.theclinick.controller.DoctorController;
import uk.wanat.theclinick.repository.DoctorRepository;
import uk.wanat.theclinick.service.DoctorServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DoctorModuleTestNotNullTest {

    @Autowired(required = false)
    private DoctorController doctorController;
    @Autowired(required = false)
    private DoctorServiceImpl doctorService;
    @Autowired(required = false)
    private DoctorRepository doctorRepository;


    @Test
    public void contexLoads() throws Exception {
        assertThat(doctorController).isNotNull();
        assertThat(doctorService).isNotNull();
        assertThat(doctorRepository).isNotNull();
    }





}