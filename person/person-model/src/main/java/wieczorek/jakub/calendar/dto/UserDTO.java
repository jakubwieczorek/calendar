package wieczorek.jakub.calendar.dto;

import java.io.Serializable;

/**
 * Created by jakub on 10.07.17.
 */
public class UserDTO implements Serializable
{
    String firstName;

    String mail;

    String surname;

    String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
