package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ClassName {

    @NotNull
    @Column(name = "name")
    private String name;

    public ClassName() {
    }
    
    public ClassName(String name) {
        this.name = name;
    }
    
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassName [name=" + name + "]";
    }

}
