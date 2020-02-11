package uk.wanat.theclinick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.wanat.theclinick.model.Address;
import uk.wanat.theclinick.model.Patient;
import uk.wanat.theclinick.model.User;
import uk.wanat.theclinick.repository.UserRepository;
import uk.wanat.theclinick.service.security.SecurityService;
import uk.wanat.theclinick.service.security.UserServiceImpl;
import uk.wanat.theclinick.validator.UserValidator;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    private SecurityService securityService;

    @Autowired
    UserValidator userValidator;

    @RequestMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }
        userServiceImpl.save(user);
        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());
        return "index";
    }



}
