package de.awtools.schoolplanner.school;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class SchoolErrorMessage {

    private static final String TIMETABLE_IS_NOT_DEFINED = "The timetable [%s, %s, %s] is not defined.";
    private static final String SCHOOL_CLASS_IS_ALREADY_DEFINED = "The schoolClass [%s, %s, %s] is already defined!";
    private static final String COURSE_IS_ALREADY_DEFINED = "The course [%s] is already defined!";
    private static final String STUDENT_IS_ALREADY_DEFINED = "The student [%s, %s %s] is already defined";
    private static final String TEACHER_IS_ALREADY_DEFINED = "The teacher [%s, %s, %s] is already defined!";
    private static final String SCHOOL_IS_ALREADY_DEFINED = "The school [%s] is already defined!";
    private static final String LESSON_IS_ALREADY_DEFINED = "The lesson [%s, %s, %s StartTime: %s] is already defined!";

    private static final String UNDEFINED = "undefined";

    private static String toString(Birthday birthday) {
        return birthday == null ? UNDEFINED
                : DateTimeFormatter.ISO_LOCAL_DATE
                        .format(birthday.getBirthday());
    }

    private static String toString(LessonStartTime startTime) {
        return startTime == null ? UNDEFINED
                : DateTimeFormatter.ISO_LOCAL_TIME
                        .format(startTime.getStartTime());
    }

    public Message schoolIsAlreadyDefined(SchoolShortName shortname) {
        return new Message(String.format(SCHOOL_IS_ALREADY_DEFINED, shortname));
    }

    public Message teacherIsAlreadyDefined(Firstname firstname, Name name,
            Birthday birthday) {
        return new Message(String.format(TEACHER_IS_ALREADY_DEFINED, name,
                firstname, toString(birthday)));
    }

    public Message studentIsAlreadyDefined(Firstname firstname, Name name,
            Birthday birthday) {
        return new Message(String.format(STUDENT_IS_ALREADY_DEFINED, name,
                firstname, toString(birthday)));
    }

    public Message schoolClassIsAlreadyDefined(ClassName name, ClassYear year,
            School school) {
        return new Message(String.format(SCHOOL_CLASS_IS_ALREADY_DEFINED, name,
                year, school.getShortName()));
    }

    public Message courseIsAlreadyDefined(CourseShortName shortName) {
        return new Message(String.format(COURSE_IS_ALREADY_DEFINED, shortName));
    }

    public Message lessonIsAlreadyDefined(Timetable timetable, Course course,
            LessonDayOfWeek dayOfWeek, LessonStartTime startTime) {
        return new Message(String.format(LESSON_IS_ALREADY_DEFINED, timetable,
                course, dayOfWeek, toString(startTime)));
    }

    public Message timetableIsNotDefined(Timetable timetable) {
        return new Message(String.format(TIMETABLE_IS_NOT_DEFINED,
                timetable.getId(), timetable.getSchoolClass().getName(),
                timetable.getSchoolClass().getYear()));
    }

}
