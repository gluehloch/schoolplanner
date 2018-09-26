package de.awtools.schoolplanner.school;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private TimetableRepository timetableRepository;

    public SchoolClass findSchoolClass() {
        return null;
    }
    
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
            throw new IllegalArgumentException(String
                    .format("School [%s] is already defined!", shortname));
        }
    }

    @Transactional
    public Teacher createTeacher(String firstname, String name,
            LocalDate birthday, String telephone, String email) {

        List<Teacher> teachers = teacherRepository
                .findByFirstnameAndNameAndBirthday(firstname, name, birthday);

        if (teachers.isEmpty()) {
            Teacher teacher = new Teacher();
            teacher.setFirstname(firstname);
            teacher.setName(name);
            teacher.setEmail(email);
            teacher.setTelephone(telephone);
            teacher.setBirthday(birthday);
            Teacher save = teacherRepository.save(teacher);
            return save;
        } else {
            throw new IllegalArgumentException(String.format(
                    "The teacher [%s, %s Birthday: %s]", name, firstname,
                    birthday == null ? "undefined"
                            : DateTimeFormatter.ISO_LOCAL_DATE
                                    .format(birthday)));
        }
    }

    @Transactional
    public Student createStudent(String firstname, String name,
            LocalDate birthday, String telephone, String email) {

        List<Student> students = studentRepository
                .findByFirstnameAndNameAndBirthday(firstname, name, birthday);

        if (students.isEmpty()) {
            Student teacher = new Student();
            teacher.setFirstname(firstname);
            teacher.setName(name);
            teacher.setEmail(email);
            teacher.setTelephone(telephone);
            teacher.setBirthday(birthday);
            Student save = studentRepository.save(teacher);
            return save;
        } else {
            throw new IllegalArgumentException(String.format(
                    "The student [%s, %s Birthday: %s]", name, firstname,
                    birthday == null ? "undefined"
                            : DateTimeFormatter.ISO_LOCAL_DATE
                                    .format(birthday)));
        }
    }

    @Transactional
    public SchoolClass createSchoolClass(String name, String year,
            School school, Teacher teacher) {

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setYear(year);
        schoolClass.setName(name);
        schoolClass.setTeacher(teacher);
        schoolClass.setSchool(school);
        schoolClassRepository.save(schoolClass);
        return schoolClass;
    }

    @Transactional
    public Course createCourse(String shortName, String name) {
        List<Course> courses = courseRepository.findByShortName(shortName);

        if (courses.isEmpty()) {
            Course course = new Course();
            course.setShortName(shortName);
            course.setName(name);
            courseRepository.save(course);
            return course;
        } else {
            throw new IllegalArgumentException(String
                    .format("Course [%s] is already defined!", shortName));
        }
    }

    @Transactional
    public Lesson createLesson(Course course, DayOfWeek dayOfWeek,
            LocalTime startTime, LocalTime endTime) {

        Lesson lesson = new Lesson();
        lesson.setStartTime(startTime);
        lesson.setEndTime(endTime);
        lesson.setCourse(course);
        lesson.setDayOfWeek(dayOfWeek);
        lessonRepository.save(lesson);
        return lesson;
    }

    @Transactional
    public Timetable createTimetable(SchoolClass schoolClass) {
        Timetable timetable = new Timetable();
        timetable.setSchoolClass(schoolClass);
        timetableRepository.save(timetable);
        return timetable;
    }

}
