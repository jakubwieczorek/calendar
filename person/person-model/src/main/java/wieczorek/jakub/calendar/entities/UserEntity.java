package wieczorek.jakub.calendar.entities;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import wieczorek.jakub.calendar.dto.UserDTO;

import javax.persistence.*;

/**
 * Created by jakub on 09.07.17.
 */
@Entity
@Table(name = "Person")
public class UserEntity
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "SURNAME")
    String surname;

    @Column(name = "MAIL")
    String mail;

    @Column(name = "PASSWORD")
    String password;

    public UserEntity() {
    }

    public UserEntity(UserDTO aUserDTO)
    {
        this.setPassword(aUserDTO.getPassword());
        this.setMail(aUserDTO.getMail());
        this.setFirstName(aUserDTO.getFirstName());
        this.setSurname(aUserDTO.getSurname());
    }

    public UserDTO toDTO()
    {
        UserDTO result = new UserDTO();

        result.setSurname(this.getSurname());
        result.setFirstName(this.getFirstName());
        result.setMail(this.getMail());
        result.setPassword(this.getPassword());

        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
}
