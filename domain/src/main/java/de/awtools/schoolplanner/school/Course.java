package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Embedded
	private CourseShortName shortName;

	@Embedded
	private CourseName name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseShortName getShortName() {
		return shortName;
	}

	public void setShortName(CourseShortName shortName) {
		this.shortName = shortName;
	}

	public CourseName getName() {
		return name;
	}

	public void setName(CourseName name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "Course [id=" + id + ", shortName=" + shortName + ", name="
                + name + "]";
    }

}
