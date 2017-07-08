package wieczorek.jakub.calendar.model;

import java.io.Serializable;

/**
 * Created by jakub on 12.05.17.
 */
public class User implements Serializable
{
    private String username;

    private String mail;

    private String password;

    public User(){}

    public User(String username, String mail, String password)
    {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
