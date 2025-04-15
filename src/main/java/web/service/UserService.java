package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void save(User user);
    public void update(User user);

    public User getUserById(Long id);

    public void deleteUser(Long id);
}
