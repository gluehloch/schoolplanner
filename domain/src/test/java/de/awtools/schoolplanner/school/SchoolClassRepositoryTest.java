package de.awtools.schoolplanner.school;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.awtools.schoolplanner.PersistenceJPAConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class })
public class SchoolClassRepositoryTest {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Test
    @Transactional
    public void findSchoolClass() {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName("5c");
        schoolClass.setSchool(new School());
        schoolClass.setTeacher(new Teacher());
        schoolClass.setYear("2018/2019");
        schoolClassRepository.save(schoolClass);
    }

}
