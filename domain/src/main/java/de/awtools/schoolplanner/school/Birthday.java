package de.awtools.schoolplanner.school;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Birthday {

    @Column(name = "birthday")
    private LocalDate birthday;

    public Birthday() {
    }

    public Birthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Birthday [birthday=" + birthday + "]";
    }

}
