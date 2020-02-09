package uk.wanat.theclinick.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.AppointmentDetails;
import uk.wanat.theclinick.repository.AppointmentRepository;

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
class AppointmentServiceImplTest {

    public static final long ID = 1L;
    @Mock
    AppointmentRepository appointmentRepository;

    @InjectMocks
    AppointmentServiceImpl appointmentServiceImpl;

    Appointment returnAppointment;

    @BeforeEach
    void setUp() {
        returnAppointment = Appointment.builder().id(ID).build();
    }

    @Test
    void findById() {
        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(returnAppointment));
        Optional<Appointment> appointmentServiceImplById = appointmentServiceImpl.findById(1l);
        assertNotNull(appointmentServiceImplById);
    }

    @Test
    void findFirstById() {
        when(appointmentRepository.findFirstById(anyLong())).thenReturn(returnAppointment);

        Appointment appointmentDetailsServiceImplFirstById = appointmentServiceImpl.findFirstById(ID);

        assertEquals(returnAppointment, appointmentDetailsServiceImplFirstById);
        assertEquals(ID, appointmentDetailsServiceImplFirstById.getId());

    }

    @Test
    void findAll() {
        List<Appointment> returnAppointmentDetailsList = new ArrayList<>();
        returnAppointmentDetailsList.add(Appointment.builder().id(1l).build());
        returnAppointmentDetailsList.add(Appointment.builder().id(2l).build());

        when(appointmentRepository.findAll()).thenReturn(returnAppointmentDetailsList);

        List<Appointment> appointmentServiceImplAll = appointmentServiceImpl.findAll();

        assertNotNull(appointmentServiceImplAll);
        assertEquals(2, appointmentServiceImplAll.size());

    }

    @Test
    void create() {
        Appointment appointmentToSave = Appointment.builder().id(1L).build();

        when(appointmentRepository.save(any())).thenReturn(returnAppointment);

        Appointment appointmentSaved = appointmentServiceImpl.create(appointmentToSave);

        assertNotNull(appointmentSaved);
        verify(appointmentRepository).save(any());

    }

    @Test
    void deleteById() {
        appointmentServiceImpl.deleteById(ID);
        verify(appointmentRepository).deleteById(anyLong());
    }
}