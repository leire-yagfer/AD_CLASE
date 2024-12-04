package it.juan.user.repositorios;

import java.util.List;

import it.juan.user.entity.User;


public interface UserDAO {

    public List<User> findAll();

    public User findById(int id);

    public void save(User user);

    public void deleteById(int id);
}

