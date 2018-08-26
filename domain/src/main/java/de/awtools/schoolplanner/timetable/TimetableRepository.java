package de.awtools.schoolplanner.timetable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable, Long> {

}
