package chapter6.ex01.plainJdbc;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 06-Oct-17.
 */
public class Contact implements Serializable{
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private List<ContactTelDetail> contactTelDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    @Override
    public String toString() {
        return "Contact - Id: " + id + " Name: "+firstName+ " "+lastName + " Birthday: "+birthday;
    }
}