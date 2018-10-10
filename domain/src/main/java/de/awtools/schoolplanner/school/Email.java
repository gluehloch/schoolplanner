package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {

    @Column(name = "email")
    private String email;

    public Email() {
    }
    
    public Email(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email [email=" + email + "]";
    }

}
