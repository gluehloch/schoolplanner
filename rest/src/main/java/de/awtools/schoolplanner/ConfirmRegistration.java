package de.awtools.schoolplanner;

/**
 * Contains an URL which the user has to click to confirm his email address.
 * 
 * @author winkler
 */
public class ConfirmRegistration {

    private final String clickMe;

    public ConfirmRegistration(String clickMe) {
        this.clickMe = clickMe;
    }

    public String getClickMe() {
        return clickMe;
    }

}
