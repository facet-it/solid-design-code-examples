package be.course.design.srp.personexport;

import java.time.LocalDate;

public class PersonSeparated {
    private String firstName;
    private String lastName; 
    private LocalDate dateOfBirth;
    private String gender;
    private boolean wouldWorkHere;
    private String reasonForVisit;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isWouldWorkHere() {
        return wouldWorkHere;
    }

    public void setWouldWorkHere(boolean wouldWorkHere) {
        this.wouldWorkHere = wouldWorkHere;
    }
}
