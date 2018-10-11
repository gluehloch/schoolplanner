package de.awtools.schoolplanner.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable, Long> {

    List<Timetable> findBySchoolClass(SchoolClass schoolClass);

}
