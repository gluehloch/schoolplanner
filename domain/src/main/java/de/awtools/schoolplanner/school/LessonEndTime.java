package de.awtools.schoolplanner.school;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class LessonEndTime {

    @NotNull
    @Column(name = "endtime")
    private LocalTime endTime;

    public LessonEndTime() {
    }
    
    public LessonEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "LessonEndTime [endTime=" + endTime + "]";
    }

}
