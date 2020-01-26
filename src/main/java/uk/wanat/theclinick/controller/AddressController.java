package uk.wanat.theclinick.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.service.AddressServiceImpl;
import uk.wanat.theclinick.service.PatientServiceImpl;
@Slf4j
@Controller
public class AddressController {

    private String patientId;

    @Autowired
    AddressServiceImpl addressServiceImpl;

    @Autowired
    PatientServiceImpl patientServiceImpl;

    @RequestMapping("/showAllAddresses")
    public String showAllAddresses(Model model) {
        log.debug("Getting all adresses");
        model.addAttribute("addressesList", addressServiceImpl.findAll());
        return "address/address-show-all";
    }

    @RequestMapping("/address/{id}/addAddress")
    public String addAddress(Model model, @PathVariable String id) {
        patientId = id;
        model.addAttribute("address", new Address());
        return "address/add-address-form";
    }

    @PostMapping("/address/addAddress")
    public String addAddress(@ModelAttribute Address address) {
        Patient patient = patientServiceImpl.findFirstById(Long.valueOf(patientId));
        addressServiceImpl.create(address);
        patient.setAddress(address);
        patientServiceImpl.update(patient.getId(), patient);
        return "redirect:/showAllPatients";
    }

    @RequestMapping("/address/{id}/update")
    public String updateAddress(@PathVariable String id, Model model) {
        model.addAttribute("address", addressServiceImpl.findFirstById(Long.valueOf(id)));
        return "address/update-address";
    }

    @PostMapping("/address")
    public String updateAddress(@ModelAttribute Address address) {
        addressServiceImpl.update(address.getId(), addressServiceImpl.create(address));
        return "index";
    }
}
