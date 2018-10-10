package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class SchoolName {

    @NotNull
    @Column(name = "name")
    private String name;

    public SchoolName() {
    }
    
    public SchoolName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SchoolName [name=" + name + "]";
    }

}
