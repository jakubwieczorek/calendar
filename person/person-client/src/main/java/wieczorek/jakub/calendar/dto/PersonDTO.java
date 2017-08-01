package wieczorek.jakub.calendar.dto;

import java.io.Serializable;
import java.util.function.LongToIntFunction;

/**
 * Created by jakub on 10.07.17.
 */
public class PersonDTO implements Serializable
{
    private Long id;

    private String firstName;

    private String mail;

    private String surname;

    private String password;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
