package de.awtools.schoolplanner.security;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Describes a password.
 * 
 * @author winkler
 */
@Embeddable
public class Password {

    @NotNull
    @Column(name = "password")
    @Size(min = 60, max = 60)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
