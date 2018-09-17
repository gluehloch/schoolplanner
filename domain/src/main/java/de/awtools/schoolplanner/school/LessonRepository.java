package de.awtools.schoolplanner.school;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    /**
     * Find all lessons of a person for a day.
     */
    List<Lesson> findByDayOfWeek(Person person, DayOfWeek dayOfWeek);

}
