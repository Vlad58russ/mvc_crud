package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public User fineOne(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}