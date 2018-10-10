package de.awtools.schoolplanner.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository
        extends CrudRepository<Lesson, Long>, CustomizedLessonRepository {

    List<Lesson> findByTimetableAndCourseAndDayOfWeekAndStartTime(
            Timetable timetable, Course course, LessonDayOfWeek dayOfWeek,
            LessonStartTime startTime);

}
