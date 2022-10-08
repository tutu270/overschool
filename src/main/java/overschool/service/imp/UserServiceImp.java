package overschool.service.imp;

import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;
import overschool.entity.User;
import overschool.repository.UserRepository;
import overschool.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Resource
    UserRepository userRepository;

    @Override
    public String addUser(User user) {
        Long userId = YitIdHelper.nextId();
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.reverse();
        userId = Long.parseLong(sb.toString()) / 1000000;
        System.out.println(userId);
        user.setUserId(userId);
        if (userRepository.isExistUser(user) == null) {
            if (userRepository.addUser(user) > 0) {
                return "ok";
            } else {
                return "no";
            }
        } else {
            return "already";
        }

    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.getAllUser();
        return users;
    }

    @Override
    public User getIndexUser(User id) {
        User user = userRepository.getIndexUser(id);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public String login(User user) {
        User paw = userRepository.login(user);
        if (paw != null) {
//            StpUtil.login(paw.getUserId());
//            return SaResult.ok("ok").toString();
            return "ok";
        } else {
                return "no";
//            return SaResult.error("no").toString();
        }
    }
}
