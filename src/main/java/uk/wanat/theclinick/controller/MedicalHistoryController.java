package uk.wanat.theclinick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.wanat.theclinick.model.MedicalHistory;
import uk.wanat.theclinick.service.MedicalHistoryServiceImpl;

@Controller
public class MedicalHistoryController {

    @Autowired
    MedicalHistoryServiceImpl medicalHistoryServiceImpl;

    @RequestMapping("/medicalHistory/addMedicalHistory")
    public String addMedicalHistory(Model model) {
        model.addAttribute("medicalHistory", new MedicalHistory());
        return "medical-history/add-medical-history-form";
    }

    @PostMapping("/medicalHistory/addMedicalHistory")
    public String addMedicalHistory(@ModelAttribute MedicalHistory medicalHistory) {
        medicalHistoryServiceImpl.create(medicalHistory);
        return "index";
    }

    @RequestMapping("/medicalHistory/{id}/update")
    public String updateDoctor(@PathVariable String id, Model model){
        model.addAttribute("medicalHistory", medicalHistoryServiceImpl.findById(Long.valueOf(id)));
        return "medical-history/update-medical-history";
    }

    @PostMapping("/medicalHistory")
    public String updateDoctor(@ModelAttribute MedicalHistory medicalHistory){
        medicalHistoryServiceImpl.update(medicalHistory.getId(), medicalHistory);
        return "index";
    }

}
