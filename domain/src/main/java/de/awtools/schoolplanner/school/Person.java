package de.awtools.schoolplanner.school;

import java.util.Formattable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person implements Formattable {

    @Embedded
	private Name name;

    @Embedded
 	private Firstname firstname;

    @Embedded
	private Birthday birthday;

    @Embedded
	private Telephone telephone;

	@Embedded
	private Email email;

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

	public Birthday getBirthday() {
		return birthday;
	}

	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

    @Override
    public String toString() {
        return "Person [name=" + name + ", firstname=" + firstname
                + ", birthday=" + birthday + ", telephone=" + telephone
                + ", email=" + email + "]";
    }

}