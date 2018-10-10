package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Embedded
	private SchoolShortName shortName;

	@Embedded
	private SchoolName name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SchoolShortName getShortName() {
		return shortName;
	}

	public void setShortName(SchoolShortName shortName) {
		this.shortName = shortName;
	}

	public SchoolName getName() {
		return name;
	}

	public void setName(SchoolName name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "School [id=" + id + ", shortName=" + shortName + ", name="
                + name + "]";
    }

}
