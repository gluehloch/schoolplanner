package de.awtools.schoolplanner.school;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telephone {

    @Column(name = "telephone")
    private String telephone;

    public Telephone() {
    }
    
    public Telephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Telephone [telephone=" + telephone + "]";
    }

}
