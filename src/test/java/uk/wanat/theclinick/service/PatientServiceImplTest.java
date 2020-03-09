package uk.wanat.theclinick.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.repository.PatientRepository;

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
public class PatientServiceImplTest {

    public static final long ID = 1L;
    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    PatientServiceImpl patientService;

    Patient returnPatient;

    @BeforeEach
    void setUp() {
        returnPatient = Patient.builder().id(ID).build();
    }

    @Test
    void findById() {
        when(patientRepository.findById(anyLong())).thenReturn(Optional.of(returnPatient));

        Optional<Patient> addressServiceImplById = patientService.findById(1l);

        assertNotNull(addressServiceImplById);

    }

    @Test
    void findFirstById() {
        when(patientRepository.findFirstById(any())).thenReturn(returnPatient);
        Patient patientServiceFirstById = patientService.findFirstById(ID);
        assertEquals(ID, patientServiceFirstById.getId());
    }

    @Test
    void findAll() {
        List<Patient> returnPatientList = new ArrayList<>();
        returnPatientList.add(Patient.builder().id(2L).build());
        returnPatientList.add(Patient.builder().id(3L).build());

        when(patientRepository.findAll()).thenReturn(returnPatientList);

        List<Patient> patientsServiceAll = patientService.findAll();

        assertNotNull(returnPatientList);
        assertEquals(2, patientsServiceAll.size());
    }

    @Test
    void create() {
        Patient patientToSave = Patient.builder().id(1L).build();

        when(patientRepository.save(any())).thenReturn(returnPatient);

        Patient doctorSaved = patientService.create(patientToSave);

        assertNotNull(doctorSaved);
        verify(patientRepository).save(any());
    }


    @Test
    void deleteById() {
        patientService.deleteById(1L);
        verify(patientRepository).deleteById(anyLong());
    }
}