package overschool.service;

import overschool.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    String addUser(User user);

    Map<String, Object> getAllUser();
    User getIndexUser(User id);

    String login(User user);
    String logout(User user);
}
