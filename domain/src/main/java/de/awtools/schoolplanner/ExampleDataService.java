package de.awtools.schoolplanner;

import static de.awtools.schoolplanner.school.SchoolService.className;
import static de.awtools.schoolplanner.school.SchoolService.classYear;
import static de.awtools.schoolplanner.school.SchoolService.courseName;
import static de.awtools.schoolplanner.school.SchoolService.courseShortName;
import static de.awtools.schoolplanner.school.SchoolService.email;
import static de.awtools.schoolplanner.school.SchoolService.firstname;
import static de.awtools.schoolplanner.school.SchoolService.lessonDayOfWeek;
import static de.awtools.schoolplanner.school.SchoolService.lessonEndTime;
import static de.awtools.schoolplanner.school.SchoolService.lessonStartTime;
import static de.awtools.schoolplanner.school.SchoolService.name;
import static de.awtools.schoolplanner.school.SchoolService.schoolName;
import static de.awtools.schoolplanner.school.SchoolService.schoolShortName;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.awtools.schoolplanner.school.Course;
import de.awtools.schoolplanner.school.Lesson;
import de.awtools.schoolplanner.school.School;
import de.awtools.schoolplanner.school.SchoolClass;
import de.awtools.schoolplanner.school.SchoolService;
import de.awtools.schoolplanner.school.Student;
import de.awtools.schoolplanner.school.Teacher;
import de.awtools.schoolplanner.school.Timetable;

@Component
public class ExampleDataService {

    private static final LocalTime H_13_25 = LocalTime.of(13, 25);
    private static final LocalTime H_14_10 = LocalTime.of(14, 10);
    private static final LocalTime H_12_40 = LocalTime.of(12, 40);
    private static final LocalTime H_12_35 = LocalTime.of(12, 35);
    private static final LocalTime H_11_50 = LocalTime.of(11, 50);
    private static final LocalTime H_11_30 = LocalTime.of(11, 30);
    private static final LocalTime H_10_00 = LocalTime.of(10, 0);
    private static final LocalTime H_09_30 = LocalTime.of(9, 30);
    private static final LocalTime H_08_00 = LocalTime.of(8, 0);

    private static final Logger logger = LogManager
            .getLogger(ExampleDataService.class);

    @Autowired
    private SchoolService schoolService;

    @Transactional
    public SchoolClass createSchoolClass() {
        logger.info("Start creating example data ...");

        School school = schoolService.createSchool(
                schoolShortName("AVH"),
                schoolName("Alexander von Humboldt Gymnasium"));

        Teacher teacher = schoolService.createTeacher(
                firstname("Letpery"),
                name("Murphy"), null, null,
                email("pf@avh.hamburg"));

        Student student = schoolService.createStudent(
                firstname("Lars"),
                name("Winkler"), null, null, null);

        SchoolClass schoolClass = schoolService.createSchoolClass(
                className("5c"),
                classYear("2018/2019"),
                school,
                teacher);

        schoolClass.getStudents().add(student);

        Course biologie = schoolService.createCourse(
                courseShortName("Bio"),
                courseName("Biologie"));
        Course sport = schoolService.createCourse(
                courseShortName("Sport"),
                courseName("Sport"));
        Course mathe = schoolService.createCourse(
                courseShortName("M"),
                courseName("Mathematik"));
        Course deutsch = schoolService.createCourse(
                courseShortName("D"),
                courseName("Deutsch"));
        Course religion = schoolService.createCourse(
                courseShortName("Reli"),
                courseName("Religion"));
        Course englisch = schoolService.createCourse(
                courseShortName("E"),
                courseName("Englisch"));
        Course technik = schoolService.createCourse(
                courseShortName("Tech"),
                courseName("Technik"));
        Course geographie = schoolService.createCourse(
                courseShortName("Geo"),
                courseName("Geographie"));
        Course kunst = schoolService.createCourse(
                courseShortName("Ku"),
                courseName("Kunst"));
        Course musik = schoolService.createCourse(
                courseShortName("Mu"),
                courseName("Musik"));
        Course lernenLernen = schoolService.createCourse(
                courseShortName("LL"),
                courseName("LernenLernen"));
        Course klassenrat = schoolService.createCourse(
                courseShortName("KR"),
                courseName("Klassenrat"));

        Timetable timetable = schoolService.createTimetable(schoolClass);

        // Montag
        Lesson deutschMontag = schoolService.createLesson(
                timetable,
                deutsch,
                lessonDayOfWeek(DayOfWeek.MONDAY),
                lessonStartTime(H_08_00),
                lessonEndTime(H_09_30));
        Lesson religionMontag = schoolService.createLesson(
                timetable,
                religion,
                lessonDayOfWeek(DayOfWeek.MONDAY),
                lessonStartTime(H_10_00),
                lessonEndTime(H_11_30));
        Lesson englischMontag = schoolService.createLesson(
                timetable,
                englisch,
                lessonDayOfWeek(DayOfWeek.MONDAY),
                lessonStartTime(H_11_50),
                lessonEndTime(H_12_35));
        Lesson technikMontag = schoolService.createLesson(
                timetable,
                technik,
                lessonDayOfWeek(DayOfWeek.MONDAY),
                lessonStartTime(H_12_40),
                lessonEndTime(H_14_10));

        // Dienstag
        Lesson matheDienstag = schoolService.createLesson(
                timetable,
                mathe,
                lessonDayOfWeek(DayOfWeek.TUESDAY),
                lessonStartTime(H_08_00),
                lessonEndTime(H_09_30));
        Lesson deutschDienstag = schoolService.createLesson(
                timetable,
                deutsch,
                lessonDayOfWeek(DayOfWeek.TUESDAY),
                lessonStartTime(H_10_00),
                lessonEndTime(H_11_30));
        Lesson geographie1Dienstag = schoolService.createLesson(
                timetable,
                geographie,
                lessonDayOfWeek(DayOfWeek.TUESDAY),
                lessonStartTime(H_11_50),
                lessonEndTime(H_12_35));
        Lesson geographie2Dienstag = schoolService.createLesson(
                timetable,
                geographie,
                lessonDayOfWeek(DayOfWeek.TUESDAY),
                lessonStartTime(H_12_40),
                lessonEndTime(H_13_25));
        
        // Mittwoch
        Lesson biologieMittwoch = schoolService.createLesson(
                timetable,
                biologie,
                lessonDayOfWeek(DayOfWeek.WEDNESDAY),
                lessonStartTime(H_08_00),
                lessonEndTime(H_09_30));
        Lesson sportMittwoch = schoolService.createLesson(
                timetable,
                sport,
                lessonDayOfWeek(DayOfWeek.WEDNESDAY),
                lessonStartTime(H_10_00),
                lessonEndTime(H_11_30));
        Lesson kunst1Mittwoch = schoolService.createLesson(
                timetable,
                kunst,
                lessonDayOfWeek(DayOfWeek.WEDNESDAY),
                lessonStartTime(H_11_50),
                lessonEndTime(H_12_35));
        Lesson kunst2Mittwoch = schoolService.createLesson(
                timetable,
                kunst,
                lessonDayOfWeek(DayOfWeek.WEDNESDAY),
                lessonStartTime(H_12_40),
                lessonEndTime(H_13_25));
        
        // Donnerstag
        Lesson englischDonerstag = schoolService.createLesson(
                timetable,
                englisch,
                lessonDayOfWeek(DayOfWeek.THURSDAY),
                lessonStartTime(H_08_00),
                lessonEndTime(H_09_30));
        Lesson matheDonnerstag = schoolService.createLesson(
                timetable,
                mathe,
                lessonDayOfWeek(DayOfWeek.THURSDAY),
                lessonStartTime(H_10_00),
                lessonEndTime(H_11_30));
        Lesson musik1Donnerstag = schoolService.createLesson(
                timetable,
                musik,
                lessonDayOfWeek(DayOfWeek.THURSDAY),
                lessonStartTime(H_11_50),
                lessonEndTime(H_12_35));
        Lesson musik2Donnerstag = schoolService.createLesson(
                timetable,
                musik,
                lessonDayOfWeek(DayOfWeek.THURSDAY),
                lessonStartTime(H_12_40),
                lessonEndTime(H_13_25));
        
        // Freitag
        Lesson lernenLernenFreitag = schoolService.createLesson(
                timetable,
                lernenLernen,
                lessonDayOfWeek(DayOfWeek.FRIDAY),
                lessonStartTime(H_08_00),
                lessonEndTime(H_09_30));
        Lesson englischFreitag = schoolService.createLesson(
                timetable,
                englisch,
                lessonDayOfWeek(DayOfWeek.FRIDAY),
                lessonStartTime(H_10_00),
                lessonEndTime(H_11_30));
        Lesson sportFreitag = schoolService.createLesson(
                timetable,
                sport,
                lessonDayOfWeek(DayOfWeek.FRIDAY),
                lessonStartTime(H_11_50),
                lessonEndTime(H_12_35));
        Lesson klassenratFreitag = schoolService.createLesson(
                timetable,
                klassenrat,
                lessonDayOfWeek(DayOfWeek.FRIDAY),
                lessonStartTime(H_12_40),
                lessonEndTime(H_13_25));

        return schoolClass;
    }
    
}
