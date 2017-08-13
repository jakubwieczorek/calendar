package wieczorek.jakub.calendar.entities;

import wieczorek.jakub.calendar.dto.EventDTO;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by jakub on 03.08.17.
 */
@Entity
@Table(name = "event")
public class EventEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EVENT_DATE")
    private Date eventDate;

    public EventDTO toDto()
    {
        EventDTO eventDTO = new EventDTO();

        eventDTO.setDescription(getDescription());
        eventDTO.setEventDate(getEventDate());
        eventDTO.setId(getId());

        return eventDTO;
    }

    public EventEntity(EventDTO eventDTO)
    {
        this.description = eventDTO.getDescription();
        this.eventDate = eventDTO.getEventDate();
    }

    public EventEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}


