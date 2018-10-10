package de.awtools.schoolplanner.school;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class LessonStartTime {

    @NotNull
    @Column(name = "starttime")
    private LocalTime startTime;

    public LessonStartTime() {
    }
    
    public LessonStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "LessonStartTime [startTime=" + startTime + "]";
    }

}
