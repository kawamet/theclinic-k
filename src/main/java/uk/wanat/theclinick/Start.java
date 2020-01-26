package uk.wanat.theclinick;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.service.DoctorServiceImpl;

import java.util.List;

@RestController
public class Start {

    @Autowired
    DoctorServiceImpl doctorService;

    @GetMapping("/hello")
    public String sayHello(){
        return "hello!!";
    }


    @GetMapping("/check")
    public List<Appointment> appointments(){
        Doctor doctor = doctorService.findFirstById((long) 1);
        List<Appointment> appointments = doctor.getAppointments();
        return appointments;
    }
}
