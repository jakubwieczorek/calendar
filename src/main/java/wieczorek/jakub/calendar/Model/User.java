package wieczorek.jakub.calendar.Model;

/**
 * Created by jakub on 12.05.17.
 */
public class User
{
    private String username;

    private String mail;

    public User(){}

    public User(String username, String mail) {
        this.username = username;
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
