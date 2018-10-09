package de.awtools.schoolplanner;

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

    private static final Logger logger = LogManager.getLogger(ExampleDataService.class);

    @Autowired
    private SchoolService schoolService;

    @Transactional
    public SchoolClass createSchoolClass() {
        logger.info("Start creating example data ...");        
        
        School school = schoolService.createSchool("AVH",
                "Alexander von Humboldt Gymnasium");
        Teacher teacher = schoolService.createTeacher("Letpery", "Murphy", null,
                null,
                "pf@avh.hamburg");
        Student student = schoolService.createStudent("Lars", "Winkler", null,
                null, null);
        SchoolClass schoolClass = schoolService.createSchoolClass("5c",
                "2018/2019", school,
                teacher);
        schoolClass.getStudents().add(student);

        Course biologie = schoolService.createCourse("Bio", "Biologie");
        Course sport = schoolService.createCourse("Sport", "Sport");
        Course mathe = schoolService.createCourse("M", "Mathematik");
        Course deutsch = schoolService.createCourse("D", "Deutsch");
        Course religion = schoolService.createCourse("Reli", "Religion");
        Course englisch = schoolService.createCourse("E", "Englisch");
        Course technik = schoolService.createCourse("Tech", "Technik");
        Course geographie = schoolService.createCourse("Geo", "Geographie");
        Course kunst = schoolService.createCourse("Ku", "Kunst");
        Course musik = schoolService.createCourse("Mu", "Musik");
        Course lernenLernen = schoolService.createCourse("LL", "LernenLernen");
        Course klassenrat = schoolService.createCourse("KS", "Klassenrat");

        // Montag
        Lesson deutschMontag = schoolService.createLesson(deutsch,
                DayOfWeek.MONDAY,
                H_08_00, H_09_30);
        Lesson religionMontag = schoolService.createLesson(religion,
                DayOfWeek.MONDAY,
                H_10_00, H_11_30);
        Lesson englischMontag = schoolService.createLesson(englisch,
                DayOfWeek.MONDAY,
                H_11_50, H_12_35);
        Lesson technikMontag = schoolService.createLesson(technik,
                DayOfWeek.MONDAY,
                H_12_40, H_14_10);

        Timetable timetable = schoolService.createTimetable(schoolClass);
        timetable.addLesson(deutschMontag);
        timetable.addLesson(religionMontag);
        timetable.addLesson(englischMontag);
        timetable.addLesson(technikMontag);

        // Dienstag
        Lesson matheDienstag = schoolService.createLesson(mathe,
                DayOfWeek.TUESDAY,
                H_08_00, H_09_30);
        Lesson deutschDienstrag = schoolService.createLesson(deutsch,
                DayOfWeek.TUESDAY,
                H_10_00, H_11_30);
        Lesson geographie1Dienstag = schoolService.createLesson(geographie,
                DayOfWeek.TUESDAY,
                H_11_50, H_12_35);
        Lesson geographie2Dienstag = schoolService.createLesson(geographie,
                DayOfWeek.TUESDAY,
                H_12_40, H_13_25);

        // Mittwoch
        Lesson biologieMittwoch = schoolService.createLesson(biologie,
                DayOfWeek.WEDNESDAY,
                H_08_00, H_09_30);
        Lesson sportMittwoch = schoolService.createLesson(sport,
                DayOfWeek.WEDNESDAY,
                H_10_00, H_11_30);
        Lesson kunst1Mittwoch = schoolService.createLesson(kunst,
                DayOfWeek.WEDNESDAY,
                H_11_50, H_12_35);
        Lesson kunst2Mittwoch = schoolService.createLesson(kunst,
                DayOfWeek.WEDNESDAY,
                H_12_40, H_13_25);

        // Donnerstag
        Lesson englischDonerstag = schoolService.createLesson(englisch,
                DayOfWeek.THURSDAY,
                H_08_00, H_09_30);
        Lesson matheDonnerstag = schoolService.createLesson(mathe,
                DayOfWeek.THURSDAY,
                H_10_00, H_11_30);
        Lesson musik1Donnerstag = schoolService.createLesson(musik,
                DayOfWeek.THURSDAY,
                H_11_50, H_12_35);
        Lesson musik2Donnerstag = schoolService.createLesson(musik,
                DayOfWeek.THURSDAY,
                H_12_40, H_13_25);

        // Freitag
        Lesson lernenLernenFreitag = schoolService.createLesson(lernenLernen,
                DayOfWeek.FRIDAY, H_08_00, H_09_30);
        Lesson englischFreitag = schoolService.createLesson(englisch,
                DayOfWeek.FRIDAY,
                H_10_00, H_11_30);
        Lesson sportFreitag = schoolService.createLesson(sport,
                DayOfWeek.FRIDAY, H_11_50,
                H_12_35);
        Lesson klassenratFreitag = schoolService.createLesson(klassenrat,
                DayOfWeek.FRIDAY,
                H_12_40, H_13_25);

        return schoolClass;
    }

}
