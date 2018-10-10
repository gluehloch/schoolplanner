package de.awtools.schoolplanner.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository
        extends CrudRepository<SchoolClass, Long> {

    List<SchoolClass> findByNameAndYearAndSchool(ClassName name, ClassYear year,
            School school);

}
