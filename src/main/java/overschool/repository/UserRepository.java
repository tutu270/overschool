package overschool.repository;

import org.springframework.stereotype.Repository;
import overschool.entity.User;

import java.util.List;

@Repository
public interface UserRepository {
    int addUser(User user);

    User isExistUser(User user);

    List<User> getAllUser();

    User getIndexUser(User user);

    User login(User user);

}
