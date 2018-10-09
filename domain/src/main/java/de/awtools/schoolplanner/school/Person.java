package de.awtools.schoolplanner.school;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Embedded
	private Name name;

    @Embedded
 	private Firstname firstname;

	@Column(name = "birthday")
	private LocalDate birthday;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "email")
	private String email;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Firstname getFirstname() {
		return firstname;
	}

	public void setFirstname(Firstname firstname) {
		this.firstname = firstname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}