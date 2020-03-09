package uk.wanat.theclinick.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTest {

    public static final long ID = 1L;
    @Mock
    DoctorRepository doctorRepository;

    @InjectMocks
    DoctorServiceImpl doctorService;

    Doctor returnDoctor;

    @BeforeEach
    void setUp() {
        returnDoctor = Doctor.builder().id(ID).build();
    }

    @Test
    void findById() {
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.of(returnDoctor));

        Optional<Doctor> addressServiceImplById = doctorService.findById(1l);

        assertNotNull(addressServiceImplById);

    }

    @Test
    void findFirstById() {
        when(doctorRepository.findFirstById(any())).thenReturn(returnDoctor);
        Doctor doctorServiceFirstById = doctorService.findFirstById(ID);
        assertEquals(ID, doctorServiceFirstById.getId());
    }

    @Test
    void findAll() {
        List<Doctor> returnDoctorsList = new ArrayList<>();
        returnDoctorsList.add(Doctor.builder().id(2L).build());
        returnDoctorsList.add(Doctor.builder().id(3L).build());

        when(doctorRepository.findAll()).thenReturn(returnDoctorsList);

        List<Doctor> doctorServiceAll = doctorService.findAll();

        assertNotNull(returnDoctorsList);
        assertEquals(2, doctorServiceAll.size());
    }

    @Test
    void create() {
        Doctor doctorToSave = Doctor.builder().id(1L).build();

        when(doctorRepository.save(any())).thenReturn(returnDoctor);

        Doctor doctorSaved = doctorService.create(doctorToSave);

        assertNotNull(doctorSaved);
        verify(doctorRepository).save(any());
    }


    @Test
    void deleteById() {
        doctorService.deleteById(1L);
        verify(doctorRepository).deleteById(anyLong());
    }
}