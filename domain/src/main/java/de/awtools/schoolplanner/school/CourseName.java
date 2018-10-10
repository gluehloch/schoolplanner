package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseName {

    @Column(name = "name")
    private String name;

    public CourseName() {
    }
    
    public CourseName(String name) {
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
        return "CourseName [name=" + name + "]";
    }

}
