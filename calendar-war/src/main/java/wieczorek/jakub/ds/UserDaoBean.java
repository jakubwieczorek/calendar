package wieczorek.jakub.ds;

import wieczorek.jakub.model.UserEntity;
import wieczorek.jakub.model.UserParam;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
public class UserDaoBean implements UserDao
{
    private final String FIND_QUERY = "select u from UserEntity u where u.mail=:mail";
    private final String QUERY = "select u from UserEntity u";

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<UserEntity> selectUsers()
    {
        Query query = entityManager.createQuery(QUERY, UserEntity.class);

        return query.getResultList();
    }

    @Transactional
    public UserEntity findUser(UserParam aUserParam)
    {
        try
        {
            Query query = entityManager.createQuery(FIND_QUERY, UserEntity.class);

            query.setParameter("mail", aUserParam.getMail());

            return (UserEntity) query.getSingleResult();
        } catch(NoResultException ex)
        {
            return null;
        }
    }

    @Transactional
    public void deleteUser(UserEntity aUser)
    {
        entityManager.remove(aUser);
    }

    @Transactional
    public void updateUser(UserParam aMail, UserEntity aUser)
    {
        UserEntity toUpdate = this.findUser(aMail);

        toUpdate.setSurname(aUser.getSurname());
        toUpdate.setFirstName(aUser.getFirstName());
        toUpdate.setMail(aUser.getMail());
        toUpdate.setPassword(aUser.getPassword());
    }

    @Transactional
    public void addUser(UserEntity aUser)
    {
        entityManager.persist(aUser);
    }
}
