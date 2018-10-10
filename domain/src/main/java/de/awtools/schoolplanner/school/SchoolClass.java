package de.awtools.schoolplanner.school;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "schoolclass")
public class SchoolClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Embedded
	private ClassName name;

	@Embedded
	private ClassYear year;

	@ManyToOne
	@JoinColumn(name = "teacher_ref")
	private Teacher teacher;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "school_ref")
	private School school;

	@ManyToMany
	@JoinTable(name = "class_student", joinColumns = @JoinColumn(name = "class_ref"), inverseJoinColumns = @JoinColumn(name = "student_ref"))
	private Set<Student> students = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClassName getName() {
		return name;
	}

	public void setName(ClassName name) {
		this.name = name;
	}

	public ClassYear getYear() {
		return year;
	}

	public void setYear(ClassYear year) {
		this.year = year;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

    @Override
    public String toString() {
        return "SchoolClass [id=" + id + ", name=" + name + ", year=" + year
                + "]";
    }

}
