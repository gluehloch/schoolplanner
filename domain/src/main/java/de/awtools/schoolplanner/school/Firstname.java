package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Firstname {

    @NotNull
    @Column(name = "firstname")
    private String name;

    public Firstname() {
    }

    public Firstname(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
