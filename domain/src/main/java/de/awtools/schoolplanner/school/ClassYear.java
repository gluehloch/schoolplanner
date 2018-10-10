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
    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ClassYear [year=" + year + "]";
    }

}
