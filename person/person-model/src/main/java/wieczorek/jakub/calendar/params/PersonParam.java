package wieczorek.jakub.calendar.params;

import java.io.Serializable;

/**
 * Created by jakub on 09.07.17.
 */
public class PersonParam implements Serializable
{
    private String username;
    private String mail;

    public PersonParam(String mail)
    {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
