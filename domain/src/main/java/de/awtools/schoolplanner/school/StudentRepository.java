package de.awtools.schoolplanner.school;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByFirstnameAndNameAndBirthday(Firstname firstname,
            Name name, LocalDate birthday);

}
