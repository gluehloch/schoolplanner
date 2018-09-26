package de.awtools.schoolplanner.school;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.awtools.schoolplanner.ExampleDataService;
import de.awtools.schoolplanner.PersistenceJPAConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class })
@Transactional
@Rollback
public class SchoolClassRepositoryTest {

    @Autowired
    private ExampleDataService exampleDataService;

    @Test
    public void findSchoolClass() {
        exampleDataService.createSchoolClass();
    }

}
