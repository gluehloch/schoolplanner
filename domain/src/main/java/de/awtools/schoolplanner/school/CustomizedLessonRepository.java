package de.awtools.schoolplanner.school;

import java.time.DayOfWeek;
import java.util.List;

interface CustomizedLessonRepository {

    List<Lesson> findByDayOfWeek(Person person, DayOfWeek dayOfWeek);

}
