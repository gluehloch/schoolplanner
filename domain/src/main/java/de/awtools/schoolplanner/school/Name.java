package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Name {

    @NotNull
    @Column(name = "name")
    private String name;

    public Name() {
    }
    
    public Name(String name) {
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
        return "Name [name=" + name + "]";
    }

}
