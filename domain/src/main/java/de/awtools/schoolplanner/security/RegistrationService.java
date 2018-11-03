package de.awtools.schoolplanner.security;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Register a new user. Do it with this service.
 * 
 * @author winkler
 */
@Service
public class RegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SchoolUserDetailsService userDetailsService;

    @Transactional
    public User registerNewUserAccount(String nickname, String email,
            String password, String passwordConfirm) {

        LocalDateTime now = LocalDateTime.now();

        User user = new User();
        user.setUsername(nickname);
        user.setPassword(new Password(passwordEncoder.encode(password)));
        user.setEmail(email);
        user.setCreated(now);
        user.setCredentialExpired(false);
        user.setEnabled(true);
        user.setLastChange(now);
        user.setLocked(false);

        userRepository.save(user);

        return user;
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}
