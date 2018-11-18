package de.awtools.schoolplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.awtools.schoolplanner.security.RegistrationService;
import de.awtools.schoolplanner.security.User;

@RestController
@RequestMapping("/authentication")
public class AuthenticationService {

    @Autowired
    private RegistrationService registrationService;

    @CrossOrigin
    @GetMapping(value = "/register")
    public ConfirmRegistration register(
            @PathVariable("nickname") String nickname,
            @PathVariable("password") String password,
            @PathVariable("passwordConfim") String passwordConfirm,
            @PathVariable("email") String email) {

        User newUserAccount = registrationService.registerNewUserAccount(
                nickname, email, password,
                passwordConfirm);

        // Token generieren und speichern...
        // Diese URL wird per Email an den neuen Benutzer verschickt.
        ConfirmRegistration cr = new ConfirmRegistration("TODO: URL");
        
        return cr;
    }

}
