package wieczorek.jakub.ds;

import org.springframework.stereotype.Repository;
import wieczorek.jakub.model.User;
import wieczorek.jakub.model.UserEntity;
import wieczorek.jakub.model.UserParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
public class UserDaoBean implements UserDao
{
    private final String FIND_QUERY = "select u from UserEntity u where u.username = :username";
    private final String QUERY = "from UserEntity u";

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<UserEntity> findUsers(UserParam userParam)
    {
        Query query = entityManager.createQuery(FIND_QUERY, UserEntity.class);

        query.setParameter("username", userParam.getUsername());

        return query.getResultList();
    }

    @Transactional
    public List<UserEntity> selectUsers()
    {
        Query query = entityManager.createQuery(QUERY, UserEntity.class);

        return query.getResultList();

//        UserEntity user = entityManager.find(UserEntity.class, 1L);
//
//        List<UserEntity> list = new ArrayList<UserEntity>();
//
//        list.add(user);
//
//        return list;
    }
}
