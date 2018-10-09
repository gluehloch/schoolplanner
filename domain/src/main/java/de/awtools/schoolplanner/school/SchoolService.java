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

    private static final String COURSE_S_IS_ALREADY_DEFINED = "Course [%s] is already defined!";

    private static final String THE_STUDENT_S_S_BIRTHDAY_S = "The student [%s, %s Birthday: %s]";

    private static final String THE_TEACHER_S_S_BIRTHDAY_S = "The teacher [%s, %s Birthday: %s]";

    private static final String SCHOOL_S_IS_ALREADY_DEFINED = "School [%s] is already defined!";

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
        List<School> schools = schoolRepository
                .findByShortName(new SchoolShortName(shortname));

        if (schools.isEmpty()) {
            School school = new School();
            school.setShortName(new SchoolShortName(shortname));
            school.setName(new SchoolName(name));
            School save = schoolRepository.save(school);
            return save;
        } else {
            throw new IllegalArgumentException(
                    String.format(SCHOOL_S_IS_ALREADY_DEFINED, shortname));
        }
    }

    @Transactional
    public Teacher createTeacher(String firstname, String name,
            LocalDate birthday, String telephone, String email) {

        List<Teacher> teachers = teacherRepository
                .findByFirstnameAndNameAndBirthday(new Firstname(firstname),
                        new Name(name), new Birthday(birthday));

        if (teachers.isEmpty()) {
            Teacher teacher = new Teacher();
            teacher.setFirstname(new Firstname(firstname));
            teacher.setName(new Name(name));
            teacher.setEmail(new Email(email));
            teacher.setTelephone(new Telephone(telephone));
            teacher.setBirthday(new Birthday(birthday));
            Teacher save = teacherRepository.save(teacher);
            return save;
        } else {
            throw new IllegalArgumentException(String.format(
                    THE_TEACHER_S_S_BIRTHDAY_S, name, firstname,
                    birthday == null ? "undefined"
                            : DateTimeFormatter.ISO_LOCAL_DATE
                                    .format(birthday)));
        }
    }

    @Transactional
    public Student createStudent(String firstname, String name,
            LocalDate birthday, String telephone, String email) {

        List<Student> students = studentRepository
                .findByFirstnameAndNameAndBirthday(new Firstname(firstname),
                        new Name(name), new Birthday(birthday));

        if (students.isEmpty()) {
            Student teacher = new Student();
            teacher.setFirstname(new Firstname(firstname));
            teacher.setName(new Name(name));
            teacher.setEmail(new Email(email));
            teacher.setTelephone(new Telephone(telephone));
            teacher.setBirthday(new Birthday(birthday));
            Student save = studentRepository.save(teacher);
            return save;
        } else {
            throw new IllegalArgumentException(String.format(
                    THE_STUDENT_S_S_BIRTHDAY_S, name, firstname,
                    birthday == null ? "undefined"
                            : DateTimeFormatter.ISO_LOCAL_DATE
                                    .format(birthday)));
        }
    }

    @Transactional
    public SchoolClass createSchoolClass(String name, String year,
            School school, Teacher teacher) {

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setYear(new ClassYear(year));
        schoolClass.setName(new ClassName(name));
        schoolClass.setTeacher(teacher);
        schoolClass.setSchool(school);
        schoolClassRepository.save(schoolClass);
        return schoolClass;
    }

    @Transactional
    public Course createCourse(String shortName, String name) {
        List<Course> courses = courseRepository
                .findByShortName(new CourseShortName(shortName));

        if (courses.isEmpty()) {
            Course course = new Course();
            course.setShortName(new CourseShortName(shortName));
            course.setName(new CourseName(name));
            courseRepository.save(course);
            return course;
        } else {
            throw new IllegalArgumentException(
                    String.format(COURSE_S_IS_ALREADY_DEFINED, shortName));
        }
    }

    @Transactional
    public Lesson createLesson(Course course, DayOfWeek dayOfWeek,
            LocalTime startTime, LocalTime endTime) {

        Lesson lesson = new Lesson();
        lesson.setStartTime(new LessonStartTime(startTime));
        lesson.setEndTime(new LessonEndTime(endTime));
        lesson.setCourse(course);
        lesson.setDayOfWeek(new LessonDayOfWeek(dayOfWeek));
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
