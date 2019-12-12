package uk.wanat.theclinick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "patientViewAll";
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatientView";
    }

    @PostMapping("/addPatient")
    public String showId(@ModelAttribute Patient patient, Model model) {
        List<Patient> all = patientServiceImpl.findAll();
        for (Patient patientTemp : all) {
            if (patientTemp.getNationalInsuranceNumber().equals(patient.getNationalInsuranceNumber())) {
                model.addAttribute("patient", patientTemp);
                return "patientExists";
            }
        }
        patientServiceImpl.create(patient);
        return "addedPatientView";
    }


}
