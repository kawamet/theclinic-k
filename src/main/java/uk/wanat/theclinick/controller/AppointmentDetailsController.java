package uk.wanat.theclinick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.wanat.theclinick.model.Appointment;
import uk.wanat.theclinick.model.AppointmentDetails;
import uk.wanat.theclinick.service.AppointmentDetailsServiceImpl;
import uk.wanat.theclinick.service.AppointmentServiceImpl;

@Controller
public class AppointmentDetailsController {

    @Autowired
    AppointmentDetailsServiceImpl appointmentDetailsServiceImpl;

    @Autowired
    AppointmentServiceImpl appointmentServiceImpl;

    private String appointmentID;

    @RequestMapping("/appointmentdetails/{id}/addDetails")
    public String addAppointmentDetails(@PathVariable String id, Model model) {
        appointmentID = id;
        model.addAttribute("appointmentdetails", new AppointmentDetails());
        return "appointemnet-details/add-appointment-details-form";
    }

    @PostMapping("/appointmentdetails/addDetails")
    public String addAppointmentDetails(@ModelAttribute AppointmentDetails appointmentDetails) {
        Appointment appointment = appointmentServiceImpl.findFirstById(Long.valueOf(appointmentID));
        appointmentDetailsServiceImpl.create(appointmentDetails);
        appointment.setAppointmentDetails(appointmentDetails);
        appointmentServiceImpl.update(appointment.getId(), appointment);
        return "index";
    }

    @RequestMapping("/appointmentdetails/{id}/update")
    public String updateAppointmentDetails(@PathVariable String id, Model model) {
        model.addAttribute("appointmentdetails", appointmentDetailsServiceImpl.findFirstById(Long.valueOf(id)));
        return "appointemnet-details/update-appointment-details";
    }

    @PostMapping("/appointmentdetails")
    public String updateAppointmentDetails(@ModelAttribute AppointmentDetails appointmentDetails) {
        appointmentDetailsServiceImpl.update(appointmentDetails.getId(), appointmentDetailsServiceImpl.create(appointmentDetails));
        return "index";
    }

}
