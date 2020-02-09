package uk.wanat.theclinick.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.wanat.theclinick.model.MedicalHistory;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.repository.MedicalHistoryRepository;

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
public class MedicalHistoryImplTest {

    public static final long ID = 1L;
    @Mock
    MedicalHistoryRepository medicalHistoryRepository;

    @InjectMocks
    MedicalHistoryServiceImpl medicalHistoryService;

    MedicalHistory returnMedicalHistory;

    @BeforeEach
    void setUp() {
        returnMedicalHistory = MedicalHistory.builder().id(ID).build();
    }

    @Test
    void findById() {
        when(medicalHistoryRepository.findById(anyLong())).thenReturn(Optional.of(returnMedicalHistory));

        Optional<MedicalHistory> medicalHistoryServiceById = medicalHistoryService.findById(ID);

        assertNotNull(medicalHistoryServiceById);

    }

    @Test
    void findFirstById() {
        when(medicalHistoryRepository.findFirstById(any())).thenReturn(returnMedicalHistory);
        MedicalHistory medicalHistoryServiceFirstById = medicalHistoryService.findFirstById(1L);
        assertEquals(ID, medicalHistoryServiceFirstById.getId());
    }

    @Test
    void findAll() {
        List<MedicalHistory> returnMedicalHistoryList = new ArrayList<>();
        returnMedicalHistoryList.add(MedicalHistory.builder().id(2L).build());
        returnMedicalHistoryList.add(MedicalHistory.builder().id(3L).build());

        when(medicalHistoryRepository.findAll()).thenReturn(returnMedicalHistoryList);

        List<MedicalHistory> patientsServiceAll = medicalHistoryService.findAll();

        assertNotNull(returnMedicalHistoryList);
        assertEquals(2, patientsServiceAll.size());
    }

    @Test
    void create() {
        MedicalHistory medicalHistoryToSave = MedicalHistory.builder().id(1L).build();

        when(medicalHistoryRepository.save(any())).thenReturn(returnMedicalHistory);

        MedicalHistory doctorSaved = medicalHistoryService.create(medicalHistoryToSave);

        assertNotNull(doctorSaved);
        verify(medicalHistoryRepository).save(any());
    }


    @Test
    void deleteById() {
        medicalHistoryService.deleteById(1L);
        verify(medicalHistoryRepository).deleteById(anyLong());
    }
}