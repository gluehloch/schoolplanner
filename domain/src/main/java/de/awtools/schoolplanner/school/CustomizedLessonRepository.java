package de.awtools.schoolplanner.school;

import java.time.DayOfWeek;
import java.util.List;

public interface CustomizedLessonRepository {

    /**
     * Find all lessons of a person for a day.
     */
    List<Lesson> findByDayOfWeek(Person person, DayOfWeek dayOfWeek);

}
