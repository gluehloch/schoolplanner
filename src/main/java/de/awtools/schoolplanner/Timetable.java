package de.awtools.schoolplanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "Timetable")
public class Timetable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "class_ref")
    private Class ofClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Class getOfClass() {
        return ofClass;
    }

    public void setOfClass(Class ofClass) {
        this.ofClass = ofClass;
    }

}
