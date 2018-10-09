package de.awtools.schoolplanner.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByShortName(CourseShortName shortName);

}
