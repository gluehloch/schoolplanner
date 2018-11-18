package de.awtools.schoolplanner.security;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.awtools.schoolplanner.PersistenceJPAConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class })
@Transactional
@Rollback
public class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @Test
    public void testRegistrationService() {
        UserRegistration account = registrationService
                .registerNewUserAccount("Frosch",
                        "frosch@web.de", "Frosch", "Frosch");

        assertThat(account.getPassword().get()).isNotEqualTo("Frosch");
    }

}
