package uk.wanat.theclinick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.service.PatientServiceImpl;

import java.util.List;

@Controller
public class PatientController {


    @Autowired
    PatientServiceImpl patientServiceImpl;

    public PatientController(PatientServiceImpl patientServiceImpl) {
        this.patientServiceImpl = patientServiceImpl;
    }

    @GetMapping("/showAllPatients")
    public String showPatients(Model model) {
        model.addAttribute("patientList", patientServiceImpl.findAll());
        return "patient-view-all";
    }

    @GetMapping("/patient/addPatient")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient-view";
    }

    @PostMapping("/patient/addPatient")
    public String addPatient(@ModelAttribute Patient patient, Model model) {
        List<Patient> all = patientServiceImpl.findAll();
        for (Patient patientTemp : all) {
            if (patientTemp.getNationalInsuranceNumber().equals(patient.getNationalInsuranceNumber())) {
                model.addAttribute("patient", patientTemp);
                return "patient-already-exists";
            }
        }
        patientServiceImpl.create(patient);
        return "added-patient-view";
    }

    @RequestMapping("patient/{id}/update")
    public String updateUpdate(@PathVariable String id, Model model) {
        model.addAttribute("patient", patientServiceImpl.findFirstById(Long.valueOf(id)));
        return "edit-patient";
    }

    @PostMapping("/patient")
    public String updateUpdate(@ModelAttribute Patient patient) {
        patientServiceImpl.update(patient.getId(), patient);
        return "added-patient-view";
    }

}
