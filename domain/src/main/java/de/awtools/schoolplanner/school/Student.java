package de.awtools.schoolplanner.school;

import java.util.Formatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width,
            int precision) {

        formatter.format("Person: %s, %s", getName().getName(),
                getFirstname().getName());
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", getName()=" + getName()
                + ", getFirstname()=" + getFirstname() + ", getBirthday()="
                + getBirthday() + ", getTelephone()=" + getTelephone()
                + ", getEmail()=" + getEmail() + "]";
    }

}
