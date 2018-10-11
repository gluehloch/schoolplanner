package de.awtools.schoolplanner.school;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    private SchoolErrorMessage schoolErrorMessage;

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

    // -- static helper -------------------------------------------------------

    public static Firstname firstname(String firstname) {
        return new Firstname(firstname);
    }

    public static Name name(String name) {
        return new Name(name);
    }

    public static Birthday birthday(LocalDate birthday) {
        return new Birthday(birthday);
    }

    public static Email email(String email) {
        return new Email(email);
    }

    public static SchoolShortName schoolShortName(String schoolShortName) {
        return new SchoolShortName(schoolShortName);
    }

    public static SchoolName schoolName(String schoolName) {
        return new SchoolName(schoolName);
    }

    public static ClassName className(String className) {
        return new ClassName(className);
    }

    public static ClassYear classYear(String classYear) {
        return new ClassYear(classYear);
    }

    public static CourseName courseName(String courseName) {
        return new CourseName(courseName);
    }

    public static CourseShortName courseShortName(String courseShortName) {
        return new CourseShortName(courseShortName);
    }

    public static LessonDayOfWeek lessonDayOfWeek(DayOfWeek dayOfWeek) {
        return new LessonDayOfWeek(dayOfWeek);
    }

    public static LessonStartTime lessonStartTime(LocalTime startTime) {
        return new LessonStartTime(startTime);
    }

    public static LessonEndTime lessonEndTime(LocalTime endTime) {
        return new LessonEndTime(endTime);
    }

    private static void throwIllegalArgumentException(String text) {
        throw new IllegalArgumentException(text);
    }

    // ------------------------------------------------------------------------

    public SchoolClass findSchoolClass() {
        return null;
    }

    @Transactional
    public boolean isSchoolDefined(SchoolShortName shortName) {
        return !schoolRepository.findByShortName(shortName).isEmpty();
    }

    @Transactional
    public School createSchool(SchoolShortName shortname, SchoolName name) {
        if (isSchoolDefined(shortname)) {
            throwIllegalArgumentException(schoolErrorMessage
                    .schoolIsAlreadyDefined(shortname).getText());
        }

        School school = new School();
        school.setShortName(shortname);
        school.setName(name);
        School save = schoolRepository.save(school);
        return save;
    }

    @Transactional
    public boolean isTeacherDefined(Firstname firstname, Name name,
            Birthday birthday) {

        return !teacherRepository
                .findByFirstnameAndNameAndBirthday(firstname, name, birthday)
                .isEmpty();
    }

    @Transactional
    public Teacher createTeacher(Firstname firstname, Name name,
            Birthday birthday, Telephone telephone, Email email) {

        if (isTeacherDefined(firstname, name, birthday)) {
            throwIllegalArgumentException(schoolErrorMessage
                    .teacherIsAlreadyDefined(firstname, name, birthday)
                    .getText());
        }

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
    public boolean isStudentDefined(Firstname firstname, Name name,
            Birthday birthday) {

        return !studentRepository
                .findByFirstnameAndNameAndBirthday(firstname, name, birthday)
                .isEmpty();
    }

    @Transactional
    public Student createStudent(Firstname firstname, Name name,
            Birthday birthday, Telephone telephone, Email email) {

        if (isStudentDefined(firstname, name, birthday)) {
            throwIllegalArgumentException(schoolErrorMessage
                    .studentIsAlreadyDefined(firstname, name, birthday)
                    .getText());
        }

        Student teacher = new Student();
        teacher.setFirstname(firstname);
        teacher.setName(name);
        teacher.setEmail(email);
        teacher.setTelephone(telephone);
        teacher.setBirthday(birthday);
        Student save = studentRepository.save(teacher);
        return save;
    }

    @Transactional
    public boolean isSchoolClassDefined(ClassName name, ClassYear year,
            School school) {

        return !schoolClassRepository
                .findByNameAndYearAndSchool(name, year, school).isEmpty();
    }

    @Transactional
    public SchoolClass createSchoolClass(ClassName name, ClassYear year,
            School school, Teacher teacher) {

        if (isSchoolClassDefined(name, year, school)) {
            throwIllegalArgumentException(schoolErrorMessage
                    .schoolClassIsAlreadyDefined(name, year, school).getText());
        }

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setYear(year);
        schoolClass.setName(name);
        schoolClass.setTeacher(teacher);
        schoolClass.setSchool(school);
        schoolClassRepository.save(schoolClass);
        return schoolClass;
    }

    @Transactional
    public boolean isCourseDefined(CourseShortName shortName) {
        return !courseRepository.findByShortName(shortName).isEmpty();
    }

    @Transactional
    public Course createCourse(CourseShortName shortName, CourseName name) {
        if (isCourseDefined(shortName)) {
            throwIllegalArgumentException(schoolErrorMessage
                    .courseIsAlreadyDefined(shortName).getText());
        }

        Course course = new Course();
        course.setShortName(shortName);
        course.setName(name);
        courseRepository.save(course);
        return course;
    }

    @Transactional
    public boolean isLessonDefined(Timetable timetable, Course course,
            LessonDayOfWeek dayOfWeek, LessonStartTime startTime) {

        return !lessonRepository
                .findByTimetableAndCourseAndDayOfWeekAndStartTime(timetable,
                        course, dayOfWeek, startTime)
                .isEmpty();
    }

    @Transactional
    public Lesson createLesson(Timetable timetable, Course course,
            LessonDayOfWeek dayOfWeek, LessonStartTime startTime,
            LessonEndTime endTime) {

        Optional<Timetable> checkTimetable = timetableRepository
                .findById(timetable.getId());
        Timetable timetable2 = checkTimetable
                .orElseThrow(
                        () -> new IllegalArgumentException(schoolErrorMessage
                                .timetableIsNotDefined(timetable).getText()));

        if (isLessonDefined(timetable2, course, dayOfWeek, startTime)) {
            throwIllegalArgumentException(
                    schoolErrorMessage.lessonIsAlreadyDefined(timetable2,
                            course, dayOfWeek, startTime).getText());
        }

        Lesson lesson = new Lesson();
        lesson.setStartTime(startTime);
        lesson.setEndTime(endTime);
        lesson.setCourse(course);
        lesson.setDayOfWeek(dayOfWeek);
        lessonRepository.save(lesson);

        timetable2.addLesson(lesson);

        return lesson;
    }

    @Transactional
    public boolean isTimetableDefined(SchoolClass schoolClass) {
        return !timetableRepository.findBySchoolClass(schoolClass).isEmpty();
    }

    @Transactional
    public Timetable createTimetable(SchoolClass schoolClass) {
        Timetable timetable = new Timetable();
        timetable.setSchoolClass(schoolClass);
        timetableRepository.save(timetable);
        return timetable;
    }

}
