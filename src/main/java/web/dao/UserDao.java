package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveOrUpdateUser(User user);

    public User getUserById(Long id);

    public void deleteUser(Long id);
}
