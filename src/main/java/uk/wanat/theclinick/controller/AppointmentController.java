package uk.wanat.theclinick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.model.Speciality;
import uk.wanat.theclinick.service.AppointmentServiceImpl;
import uk.wanat.theclinick.service.DoctorServiceImpl;
import uk.wanat.theclinick.service.PatientServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AppointmentController {

    private String doctorId = null;

    @Autowired
    AppointmentServiceImpl appointmentServiceImpl;

    @Autowired
    DoctorServiceImpl doctorServiceImpl;

    @Autowired
    PatientServiceImpl patientServiceImpl;


    @RequestMapping("/showAllapointments")
    public String showAllApointments(Model model) {
        model.addAttribute("appointmentList", appointmentServiceImpl.findAll());
        return "appointment/appointment-show-all";
    }


    @RequestMapping("/appointment/chooseSpeciality")
    public String chooseSpeciality(Model model) {
        List<Speciality> enums = Arrays.asList(Speciality.values());
        model.addAttribute("speciality", enums);
        return "appointment/choose-speciality";
    }


    @RequestMapping("/appointment/{speciality}/chosen")
    public String chooseSpeciality(@PathVariable String speciality, Model model) {
        List<Doctor> all = doctorServiceImpl.findAll();
        List<Doctor> doctorsWithSpecialityList = all.stream().filter(e -> e.getSpeciality().toString().equals(speciality)).collect(Collectors.toList());
        model.addAttribute("doctorsWithSpecialityList", doctorsWithSpecialityList);
        return "appointment/choose-doctor";
    }

    @RequestMapping("/appointment/{speciality}/{id}/chosen")
    public String chooseDoctor(@PathVariable String id, @PathVariable String speciality, Model model) {
        doctorId = id;
        Doctor doctor = doctorServiceImpl.findFirstById(Long.valueOf(id));
        List<Appointment> doctorAppointments = doctor.getAppointments();
        List<LocalDateTime> unbookedAppointments = getAvailableAppointments(doctorAppointments);

        model.addAttribute("availableTime", unbookedAppointments);
        model.addAttribute("appointment", new Appointment());

        return "appointment/choose-appointemnt-time";
    }

    private List<LocalDateTime> getAvailableAppointments(List<Appointment> doctorAppointments) {
        List<LocalDateTime> doctorsAppointmesLDT = doctorAppointments.stream().map(Appointment::getAppointmetDate).collect(Collectors.toList());
        List<LocalDateTime> allAppointemntsLDT = getAllAppointemntsTime();

        List<LocalDateTime> unbookedAppointments = getAllAppointemntsTime();
        for (LocalDateTime allAppointmentsTemp : allAppointemntsLDT) {
            for (LocalDateTime doctorsAppointmets : doctorsAppointmesLDT) {
                if (allAppointmentsTemp.isEqual(doctorsAppointmets)) {
                    unbookedAppointments.remove(allAppointmentsTemp);
                }
            }
        }
        return unbookedAppointments;
    }

    @PostMapping("/appointment/addAppointment")
    public String addAppointment(@ModelAttribute Appointment appointment, @ModelAttribute String appointmentTimeList) {
        appointment.setDoctor(doctorServiceImpl.findFirstById(Long.valueOf(doctorId)));
        appointmentServiceImpl.create(appointment);
        return "redirect:/showAllapointments";
    }

    @RequestMapping("/appointment/{id}/delete")
    public String deleteAppointment(@PathVariable String id) {
        appointmentServiceImpl.deleteById(Long.valueOf(id));
        return "redirect:/showAllapointments";
    }

    private List<LocalDateTime> getAllAppointemntsTime() {
        LocalDate localDateNow = LocalDate.now();
        LocalDate localDate1 = localDateNow.plusDays(7);
        List<LocalDateTime> avaiableDatesList = new ArrayList<>();

        for (LocalDate date = localDateNow; date.isBefore(localDate1); date = date.plusDays(1)) {
            LocalTime localTimeStart = LocalTime.of(9, 00);
            for (int i = 0; i < 17; i++) {
                localTimeStart = localTimeStart.plusMinutes(30);
                avaiableDatesList.add(LocalDateTime.of(date, localTimeStart));
            }
        }
        return avaiableDatesList;
    }

}
