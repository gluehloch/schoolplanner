package de.awtools.schoolplanner.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.awtools.schoolplanner.PersistenceJPAConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class })
public class SchoolClassRepositoryTest {

	@Autowired
	private SchoolService schoolService;

    
    @Test
    @Commit
    public void findSchoolClass() {
    	schoolService.createSchoolClass();
    }

}
