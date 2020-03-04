package js.fashioncloud.controller;

import js.fashioncloud.model.RegistrationForm;
import js.fashioncloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String shorRegistrationForm(){
        return "registrationForm";
    }

    @PostMapping
    public String processRegistration(RegistrationForm registrationForm){
        userRepository.save(registrationForm.mapToUser(passwordEncoder));
        return "redirect:/login";
    }
}
