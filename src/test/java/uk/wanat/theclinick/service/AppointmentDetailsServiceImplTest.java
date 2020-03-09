package uk.wanat.theclinick.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.AppointmentDetails;
import uk.wanat.theclinick.repository.AppointmentDetailsReposotory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppointmentDetailsServiceImplTest {

    public static final long ID = 1L;
    @Mock
    AppointmentDetailsReposotory appointmentDetailsReposotory;

    @InjectMocks
    AppointmentDetailsServiceImpl appointmentDetailsServiceImpl;

    AppointmentDetails returnAppointmentDetails;

    @BeforeEach
    void setUp() {
        returnAppointmentDetails = AppointmentDetails.builder().id(ID).build();
    }

    @Test
    void findById() {
        when(appointmentDetailsReposotory.findById(anyLong())).thenReturn(Optional.of(returnAppointmentDetails));
        Optional<AppointmentDetails> appointmentDetailsServiceImplById = appointmentDetailsServiceImpl.findById(1l);
        assertNotNull(appointmentDetailsServiceImplById);
    }

    @Test
    void findFirstById() {
        when(appointmentDetailsReposotory.findFirstById(anyLong())).thenReturn(returnAppointmentDetails);

        AppointmentDetails appointmentDetailsServiceImplFirstById = appointmentDetailsServiceImpl.findFirstById(ID);

        assertEquals(returnAppointmentDetails, appointmentDetailsServiceImplFirstById);
        assertEquals(ID, appointmentDetailsServiceImplFirstById.getId());

    }

    @Test
    void findAll() {
        List<AppointmentDetails> returnAppointmentDetailsList = new ArrayList<>();
        returnAppointmentDetailsList.add(AppointmentDetails.builder().id(1l).build());
        returnAppointmentDetailsList.add(AppointmentDetails.builder().id(2l).build());

        when(appointmentDetailsReposotory.findAll()).thenReturn(returnAppointmentDetailsList);

        List<AppointmentDetails> appointmentDetailsServiceImplAll = appointmentDetailsServiceImpl.findAll();

        assertNotNull(appointmentDetailsServiceImplAll);
        assertEquals(2, appointmentDetailsServiceImplAll.size());

    }

    @Test
    void create() {
        AppointmentDetails addresDetailsToSave = AppointmentDetails.builder().id(1L).build();

        when(appointmentDetailsReposotory.save(any())).thenReturn(returnAppointmentDetails);

        AppointmentDetails appointmentDetailsSaved = appointmentDetailsServiceImpl.create(addresDetailsToSave);

        assertNotNull(appointmentDetailsSaved);
        verify(appointmentDetailsReposotory).save(any());

    }

    @Test
    void deleteById() {
        appointmentDetailsServiceImpl.deleteById(ID);
        verify(appointmentDetailsReposotory).deleteById(anyLong());
    }
}