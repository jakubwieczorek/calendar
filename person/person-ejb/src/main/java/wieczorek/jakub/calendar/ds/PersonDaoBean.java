package wieczorek.jakub.calendar.ds;

import wieczorek.jakub.calendar.dto.EventDTO;
import wieczorek.jakub.calendar.entities.EventEntity;
import wieczorek.jakub.calendar.entities.PersonEntity;
import wieczorek.jakub.calendar.params.PersonParam;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
@Transactional
public class PersonDaoBean implements PersonDao
{
    private final String FIND_QUERY = "select u from PersonEntity u where u.mail=:mail";
    private final String QUERY = "select u from PersonEntity u";
    private final String EVENT_QUERY = "select e from PersonEntity u inner join u.events e where u.mail = :mail";

    @PersistenceContext(name = "person")
    EntityManager entityManager;


    public List<PersonEntity> selectUsers()
    {
        Query query = entityManager.createQuery(QUERY, PersonEntity.class);

        return (List<PersonEntity>) query.getResultList();
    }

    public PersonEntity findUser(PersonParam aPersonParam)
    {
        try
        {
            Query query = entityManager.createQuery(FIND_QUERY, PersonEntity.class);

            query.setParameter("mail", aPersonParam.getMail());

            return (PersonEntity) query.getSingleResult();
        } catch(NoResultException ex)
        {
            return null;
        }
    }

    public void deleteUser(PersonEntity aUser)
    {


        aUser = entityManager.getReference(PersonEntity.class, aUser.getId()); // aUser must be
        // attached entity (connected with database)
        entityManager.remove(aUser);

    }

    public void updateUser(PersonParam aMail, PersonEntity aUser)
    {
        PersonEntity toUpdate = this.findUser(aMail);

        toUpdate.setSurname(aUser.getSurname());
        toUpdate.setFirstName(aUser.getFirstName());
        toUpdate.setMail(aUser.getMail());
        toUpdate.setPassword(aUser.getPassword());
    }

    public void addUser(PersonEntity aUser)
    {
        entityManager.persist(aUser);
    }

    public List<EventEntity> selectEvents(PersonEntity aUser)
    {
        Query query = entityManager.createQuery(EVENT_QUERY, EventEntity.class);

        query.setParameter("mail", aUser.getMail());

        return (List<EventEntity>) query.getResultList();
    }

    public void addEventToPerson(PersonEntity aUser, EventEntity aEvent)
    {
        entityManager.persist(aEvent);

        PersonEntity toUpdate = entityManager.find(PersonEntity.class, aUser.getId());

        toUpdate.getEvents().add(aEvent);
    }
}
