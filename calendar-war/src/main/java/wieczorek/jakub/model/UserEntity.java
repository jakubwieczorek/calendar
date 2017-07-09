package wieczorek.jakub.model;

import javax.persistence.*;

/**
 * Created by jakub on 09.07.17.
 */
@Entity
@Table(name = "User")
public class UserEntity
{
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "username")
    String username;

    @Column(name = "mail")
    String mail;

    @Column(name = "password")
    String password;

    @Column(name = "event_id")
    Long eventId;

    public UserEntity() {
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
