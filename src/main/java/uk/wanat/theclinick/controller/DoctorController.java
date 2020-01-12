package uk.wanat.theclinick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.wanat.theclinick.model.Doctor;
import uk.wanat.theclinick.service.DoctorServiceImpl;

@Controller
public class DoctorController {

    @Autowired
    DoctorServiceImpl doctorServiceImpl;

    @RequestMapping("/doctor/addDoctor")
    public String addDoctor(Model model){
        model.addAttribute("doctor", new Doctor());
        return "doctor/add-doctor-form";
    }

    @PostMapping("/doctor/addDoctor")
    public String addDoctor(@ModelAttribute Doctor doctor){
        doctorServiceImpl.create(doctor);
        return "redirect:/showAllDoctors";
    }

    @RequestMapping("/doctor/{id}/update")
    public String updateDoctor(@PathVariable String id, Model model){
        model.addAttribute("doctor", doctorServiceImpl.findById(Long.valueOf(id)));
        return "doctor/update-doctor";
    }

    @PostMapping("/doctor")
    public String updateDoctor(@ModelAttribute Doctor doctor){
        doctorServiceImpl.update(doctor.getId(), doctor);
        return "redirect:/showAllDoctors";
    }

    @RequestMapping("/showAllDoctors")
    public String showAllDoctors(Model model){
        model.addAttribute("doctorList", doctorServiceImpl.findAll());
        return "doctor/doctor-show-all";
    }
}
