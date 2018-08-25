package de.awtools.schoolplanner.school;

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
	public SchoolClass createSchoolClass() {
		School school = new School();
		school.setName("Alexander von Humboldt Gymnasium");
		school.setShortName("AVH");
		schoolRepository.save(school);

		Teacher teacher = new Teacher();
		teacher.setEmail("pf@avh.hamburg");
		teacher.setFirstname("Letpery");
		teacher.setName("Murphy");
		teacherRepository.save(teacher);

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
