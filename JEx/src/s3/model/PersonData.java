package s3.model;

import s3.model.enums.Gender;

import java.time.LocalDate;

/**
 * The class represents a person data
 */
public class PersonData {
    private String lastname;
    private String firstname;
    private String middlename;
    private LocalDate birthdate;
    private long phoneNumber;
    private Gender gender;

    public PersonData() {

    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<" + lastname + "><" + firstname + "><" + middlename + "><" + birthdate + "><" + phoneNumber + "><" + gender + ">";
    }
}