package de.awtools.schoolplanner.school;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "timetable")
public class Timetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "schoolclass_ref")
	private SchoolClass schoolClass;

	@NotNull
	@OneToMany(mappedBy = "timetable")
	private List<Lesson> lessons = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	
	public List<Lesson> getLessons() {
	    return lessons;
	}
	
	public void setLesson(List<Lesson> lessons) {
	    this.lessons = lessons;
	}
	
	public void addLesson(Lesson lesson) {
	    lesson.setTimetable(this);
	    lessons.add(lesson);
	}

    @Override
    public String toString() {
        return "Timetable [id=" + id + ", schoolClass=" + schoolClass + "]";
    }

}
