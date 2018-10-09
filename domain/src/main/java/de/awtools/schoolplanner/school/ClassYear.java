package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ClassYear {

    @NotNull
    @Column(name = "year")
    private String year;

    public ClassYear() { 
    }
    
    public ClassYear(String year) {
        this.year = year;
    }
    
    String getYear() {
        return year;
    }

    void setYear(String year) {
        this.year = year;
    }

}
