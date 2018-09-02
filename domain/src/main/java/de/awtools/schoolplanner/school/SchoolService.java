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

    private static final LocalTime H_13_25 = LocalTime.of(13, 25);
    private static final LocalTime H_14_10 = LocalTime.of(14, 10);
    private static final LocalTime H_12_40 = LocalTime.of(12, 40);
    private static final LocalTime H_12_35 = LocalTime.of(12, 35);
    private static final LocalTime H_11_50 = LocalTime.of(11, 50);
    private static final LocalTime H_11_30 = LocalTime.of(11, 30);
    private static final LocalTime H_10_00 = LocalTime.of(10, 0);
    private static final LocalTime H_09_30 = LocalTime.of(9, 30);
    private static final LocalTime H_08_00 = LocalTime.of(8, 0);

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

    @Transactional
    public SchoolClass createSchoolClass() {
        School school = createSchool("AVH", "Alexander von Humboldt Gymnasium");
        Teacher teacher = createTeacher("Letpery", "Murphy", null, null,
                "pf@avh.hamburg");
        Student student = createStudent("Lars", "Winkler", null, null, null);
        SchoolClass schoolClass = createSchoolClass("5c", "2018/2019", school,
                teacher);
        schoolClass.getStudents().add(student);

        Course biologie = createCourse("Bio", "Biologie");
        Course sport = createCourse("Sport", "Sport");
        Course mathe = createCourse("M", "Mathematik");
        Course deutsch = createCourse("D", "Deutsch");
        Course religion = createCourse("Reli", "Religion");
        Course englisch = createCourse("E", "Englisch");
        Course technik = createCourse("Tech", "Technik");
        Course geographie = createCourse("Geo", "Geographie");
        Course kunst = createCourse("Ku", "Kunst");
        Course musik = createCourse("Mu", "Musik");
        Course lernenLernen = createCourse("LL", "LernenLernen");
        Course klassenrat = createCourse("KS", "Klassenrat");

        // Montag
        Lesson deutschMontag = createLesson(deutsch, DayOfWeek.MONDAY,
                H_08_00, H_09_30);
        Lesson religionMontag = createLesson(religion, DayOfWeek.MONDAY,
                H_10_00, H_11_30);
        Lesson englischMontag = createLesson(englisch, DayOfWeek.MONDAY,
                H_11_50, H_12_35);
        Lesson technikMontag = createLesson(technik, DayOfWeek.MONDAY,
                H_12_40, H_14_10);

        Timetable timetable = createTimetable(schoolClass);
        timetable.addLesson(deutschMontag);
        timetable.addLesson(religionMontag);
        timetable.addLesson(englischMontag);
        timetable.addLesson(technikMontag);

        // Dienstag
        Lesson matheDienstag = createLesson(mathe, DayOfWeek.TUESDAY,
                H_08_00, H_09_30);
        Lesson deutschDienstrag = createLesson(deutsch, DayOfWeek.TUESDAY,
                H_10_00, H_11_30);
        Lesson geographie1Dienstag = createLesson(geographie, DayOfWeek.TUESDAY,
                H_11_50, H_12_35);
        Lesson geographie2Dienstag = createLesson(geographie, DayOfWeek.TUESDAY,
                H_12_40, H_13_25);

        // Mittwoch
        Lesson biologieMittwoch = createLesson(biologie, DayOfWeek.WEDNESDAY,
                H_08_00, H_09_30);
        Lesson sportMittwoch = createLesson(sport, DayOfWeek.WEDNESDAY,
                H_10_00, H_11_30);
        Lesson kunst1Mittwoch = createLesson(kunst, DayOfWeek.WEDNESDAY,
                H_11_50, H_12_35);
        Lesson kunst2Mittwoch = createLesson(kunst, DayOfWeek.WEDNESDAY,
                H_12_40, H_13_25);

        // Donnerstag
        Lesson englischDonerstag = createLesson(englisch, DayOfWeek.THURSDAY,
                H_08_00, H_09_30);
        Lesson matheDonnerstag = createLesson(mathe, DayOfWeek.THURSDAY,
                H_10_00, H_11_30);
        Lesson musik1Donnerstag = createLesson(musik, DayOfWeek.THURSDAY,
                H_11_50, H_12_35);
        Lesson musik2Donnerstag = createLesson(musik, DayOfWeek.THURSDAY,
                H_12_40, H_13_25);

        // Freitag
        Lesson lernenLernenFreitag = createLesson(lernenLernen,
                DayOfWeek.FRIDAY, H_08_00, H_09_30);
        Lesson englischFreitag = createLesson(englisch, DayOfWeek.FRIDAY,
                H_10_00, H_11_30);
        Lesson sportFreitag = createLesson(sport, DayOfWeek.FRIDAY, H_11_50,
                H_12_35);
        Lesson klassenratFreitag = createLesson(klassenrat, DayOfWeek.FRIDAY,
                H_12_40, H_13_25);

        schoolClassRepository.save(schoolClass);
        return schoolClass;
    }

}
