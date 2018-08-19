package de.awtools.schoolplanner;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class Person {

	@NotNull
	private String name;

	@NotNull
	private String firstname;

	@NotNull
	private LocalDate birthday;

	@NotNull
	private String telephone;

	public Person() {
		super();
	}

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

}