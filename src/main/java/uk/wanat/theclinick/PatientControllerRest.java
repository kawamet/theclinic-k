package uk.wanat.theclinick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.wanat.theclinick.model.*;
import uk.wanat.theclinick.repository.AppointmentRepository;
import uk.wanat.theclinick.repository.DoctorRepository;
import uk.wanat.theclinick.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PatientControllerRest {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;


    @GetMapping("/add")
    public Patient addPatient() {
        LocalDate birthDate = LocalDate.of(1968,9,25);
        Date date = new Date();
        Patient patient = new Patient("Will", "Smith",Gender.MALE, "07776512547","SZ102030", birthDate );
        Address address = new Address("Westminster", "SW1A 0AA", "London");
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setAllergy("peanut");
        medicalHistory.setDiabetes(false);
        Login login = new Login("willsmith@gmail.com", "willsmith");
        patient.setLogin(login);
        patient.setMedicalHistory(medicalHistory);
        patient.setAddress(address);
        return patientRepository.save(patient);
    }

    @RequestMapping(value = "/deletePatient", params = "id", method = GET)
    public String deletePerson(@RequestParam("id") Long id) {
        patientRepository.deleteById(id);
        return "deleted!";
    }

    @GetMapping("/addDoctor")
    public Doctor addDoctor() {
        return doctorRepository.save(new Doctor(Speciality.DENTISTRY, "Doctor", "Who"));
    }

    @GetMapping("/addAppointment")
    public void addAppointment(){
        LocalDate localDate = LocalDate.of(2020,5,12);
        LocalTime localTime = LocalTime.of(12, 30);
        LocalDateTime appiotmentTime = LocalDateTime.of(localDate,localTime);
        Appointment appointment = new Appointment(appiotmentTime,appiotmentTime.plusMinutes(30), ExaminationRoom.A2);
        Doctor doctor = doctorRepository.findFirstById(1L);
        appointment.setDoctor(doctor);
        doctor.add(appointment);
        Patient patient = patientRepository.findFirstById(2L);
        patient.add(appointment);
        appointmentRepository.save(appointment);
    }

}