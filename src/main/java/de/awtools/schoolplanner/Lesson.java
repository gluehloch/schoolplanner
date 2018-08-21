package de.awtools.schoolplanner;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "Lesson")
public class Lesson {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "course_ref")
    private Course course;
    
    @NotNull
    @Column(name = "starttime")
    private LocalTime startTime;

    @NotNull
    @Column(name = "endtime")
    private LocalTime endTime;

    @NotNull
    @Column(name = "dayofweek")
    private DayOfWeek dayOfWekk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public DayOfWeek getDayOfWekk() {
        return dayOfWekk;
    }

    public void setDayOfWekk(DayOfWeek dayOfWekk) {
        this.dayOfWekk = dayOfWekk;
    }

}