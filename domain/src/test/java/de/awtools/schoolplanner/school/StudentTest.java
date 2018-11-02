package de.awtools.schoolplanner.school;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void student() {
        Student student = new Student();
        student.setFirstname(new Firstname("Andre"));
        student.setName(new Name("Winkler"));
        student.setBirthday(new Birthday(LocalDate.of(1971, 3, 24)));

        assertThat(student.equals(student)).isTrue();
    }

}
