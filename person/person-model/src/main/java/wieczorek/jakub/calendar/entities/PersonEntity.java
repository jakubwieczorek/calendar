package wieczorek.jakub.calendar.entities;

import wieczorek.jakub.calendar.dto.PersonDTO;

import javax.persistence.*;

/**
 * Created by jakub on 09.07.17.
 */
@Entity
@Table(name = "person")
public class PersonEntity
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "PASSWORD")
    private String password;

    public PersonEntity() {
    }

    public PersonEntity(PersonDTO aPersonDTO)
    {
        this.setPassword(aPersonDTO.getPassword());
        this.setMail(aPersonDTO.getMail());
        this.setFirstName(aPersonDTO.getFirstName());
        this.setSurname(aPersonDTO.getSurname());
    }

    public PersonDTO toDTO()
    {
        PersonDTO result = new PersonDTO();

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
