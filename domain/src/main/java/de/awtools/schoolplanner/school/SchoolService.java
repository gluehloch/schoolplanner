package de.awtools.schoolplanner.school;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public School createSchool(String shortname, String name) {
        List<School> schools = schoolRepository.findByShortName(shortname);
        if (schools.isEmpty()) {
            School school = new School();
            school.setShortName(shortname);
            school.setName(name);
            School save = schoolRepository.save(school);
            return save;
        } else {
            throw new IllegalArgumentException(
                    String.format("School [%s] is already defined!",
                            shortname));
        }
    }

    @Transactional
    public Teacher createTeacher(String firstname, String name,
            LocalDate birthday, String telephone, String email) {

        Teacher teacher = new Teacher();
        teacher.setFirstname(firstname);
        teacher.setName(name);
        teacher.setEmail(email);
        teacher.setTelephone(telephone);
        teacher.setBirthday(birthday);
        Teacher save = teacherRepository.save(teacher);
        return save;
    }

    @Transactional
    public SchoolClass createSchoolClass() {
        School school = createSchool("AVH", "Alexander von Humboldt Gymnasium");
        Teacher teacher = createTeacher("Letpery", "Murphy", null, null,
                "pf@avh.hamburg");

        Student student = new Student();
        student.setFirstname("Lars");
        student.setName("Winkler");
        studentRepository.save(student);

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName("5c");
        schoolClass.setSchool(school);
        schoolClass.setTeacher(teacher);
        schoolClass.setYear("2018/2019");

        schoolClass.getStudents().add(student);

        schoolClassRepository.save(schoolClass);
        return schoolClass;
    }

}
