package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class SchoolShortName {

    @NotNull
    @Column(name = "shortname")
    private String shortName;

    public SchoolShortName() {
    }
    
    public SchoolShortName(String shortName) {
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
        return "SchoolShortName [shortName=" + shortName + "]";
    }

}
