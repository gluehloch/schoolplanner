package de.awtools.schoolplanner.school;

import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Embeddable
public class LessonDayOfWeek {

    @NotNull
    @Column(name = "dayofweek")
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    public LessonDayOfWeek() {
    }
    
    public LessonDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "LessonDayOfWeek [dayOfWeek=" + dayOfWeek + "]";
    }

}
