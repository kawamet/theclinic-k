package uk.wanat.theclinick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.wanat.theclinick.model.AppointmentDetails;
import uk.wanat.theclinick.repository.AppointmentDetailsReposotory;

import java.util.List;
import java.util.Optional;

@Component("appointmentaetailsservice")
public class AppointmentDetailsServiceImpl implements AppointmentDetailsService {

    @Autowired
    AppointmentDetailsReposotory appointmentDetailsReposotory;


    @Override
    public Optional<AppointmentDetails> findById(Long id) {
        return appointmentDetailsReposotory.findById(id);
    }

    @Override
    public AppointmentDetails findFirstById(Long id) {
        return appointmentDetailsReposotory.findFirstById(id);
    }

    @Override
    public List<AppointmentDetails> findAll() {
        return appointmentDetailsReposotory.findAll();
    }

    @Override
    public AppointmentDetails create(AppointmentDetails appointmentDetails) {
        return appointmentDetailsReposotory.save(appointmentDetails);
    }

    @Override
    public AppointmentDetails update(Long id, AppointmentDetails appointmentDetails) {
        return appointmentDetailsReposotory.save(appointmentDetails);
    }

    @Override
    public void deleteById(Long id) {
        appointmentDetailsReposotory.deleteById(id);
    }
}
