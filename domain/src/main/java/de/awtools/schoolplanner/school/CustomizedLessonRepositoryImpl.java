package de.awtools.schoolplanner.school;

import java.time.DayOfWeek;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

class CustomizedLessonRepositoryImpl  implements CustomizedLessonRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Lesson> findByDayOfWeek(Person person, DayOfWeek dayOfWeek) {
        // entityManager.find(entityClass, primaryKey)
        return null;
    }

}
