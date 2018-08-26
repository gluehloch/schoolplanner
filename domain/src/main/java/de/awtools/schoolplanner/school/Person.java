package de.awtools.schoolplanner.school;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Person {

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "firstname")
	private String firstname;

	@Column(name = "birthday")
	private LocalDate birthday;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "email")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
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