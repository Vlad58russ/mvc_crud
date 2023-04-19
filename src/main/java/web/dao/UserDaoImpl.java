package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User fineOne(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User changed = entityManager.find(User.class, id);
        changed.setAge(updatedUser.getAge());
        changed.setName(updatedUser.getName());
        entityManager.persist(changed);
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("DELETE FROM User user WHERE user.id =: getId").setParameter("getId", id).executeUpdate();
    }
}