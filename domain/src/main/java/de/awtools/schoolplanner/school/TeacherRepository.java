package de.awtools.schoolplanner.school;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    List<Teacher> findByFirstnameAndNameAndBirthday(Firstname firstname,
            Name name, Birthday birthday);

}
