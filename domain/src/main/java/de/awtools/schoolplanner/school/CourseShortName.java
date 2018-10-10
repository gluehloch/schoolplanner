package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CourseShortName {

    @NotNull
    @Column(name = "shortname")
    private String shortName;

    public CourseShortName() {
    }
    
    public CourseShortName(String shortName) {
        this.shortName = shortName;
    }
    
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "CourseShortName [shortName=" + shortName + "]";
    }
    
}
