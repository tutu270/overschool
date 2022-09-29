package overschool.service;

import overschool.entity.User;

import java.util.List;

public interface UserService {
    String addUser(User user);

    List<User> getAllUser();
    User getIndexUser(User id);
}
