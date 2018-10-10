package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "course_ref")
    private Course course;

    @Embedded
    private LessonStartTime startTime;

    @Embedded
    private LessonEndTime endTime;

    @Embedded
    private LessonDayOfWeek dayOfWeek;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "timetable_ref")
    private Timetable timetable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LessonStartTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LessonStartTime startTime) {
        this.startTime = startTime;
    }

    public LessonEndTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LessonEndTime endTime) {
        this.endTime = endTime;
    }

    public LessonDayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(LessonDayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @Override
    public String toString() {
        return "Lesson [id=" + id + ", course=" + course + ", startTime="
                + startTime + ", endTime=" + endTime + ", dayOfWeek="
                + dayOfWeek + "]";
    }

}
