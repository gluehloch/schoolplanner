package de.awtools.schoolplanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Timetable")
public class Timetable {

    @Id
    @GeneratedValue
    private Long id;
    
}
