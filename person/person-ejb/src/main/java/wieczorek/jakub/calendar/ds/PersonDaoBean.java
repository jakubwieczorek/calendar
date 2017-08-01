package wieczorek.jakub.calendar.ds;

import wieczorek.jakub.calendar.entities.PersonEntity;
import wieczorek.jakub.calendar.params.PersonParam;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
public class PersonDaoBean implements PersonDao
{
    private final String FIND_QUERY = "select u from PersonEntity u where u.mail=:mail";
    private final String QUERY = "select u from PersonEntity u";

    @PersistenceContext(name = "person")
    EntityManager entityManager;

    @Transactional
    public List<PersonEntity> selectUsers()
    {
        Query query = entityManager.createQuery(QUERY, PersonEntity.class);

        return (List<PersonEntity>) query.getResultList();
    }

    @Transactional
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

    @Transactional
    public void deleteUser(PersonEntity aUser)
    {
        aUser = entityManager.getReference(PersonEntity.class, aUser.getId()); // aUser must be
        // attached entity (connected with database)
        entityManager.remove(aUser);
    }

    @Transactional
    public void updateUser(PersonParam aMail, PersonEntity aUser)
    {
        PersonEntity toUpdate = this.findUser(aMail);

        toUpdate.setSurname(aUser.getSurname());
        toUpdate.setFirstName(aUser.getFirstName());
        toUpdate.setMail(aUser.getMail());
        toUpdate.setPassword(aUser.getPassword());
    }

    @Transactional
    public void addUser(PersonEntity aUser)
    {
        entityManager.persist(aUser);
    }
}
