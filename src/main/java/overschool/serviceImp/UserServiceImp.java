package overschool.serviceImp;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;
import overschool.entity.User;
import overschool.repository.UserRepository;
import overschool.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public  Map<String, Object> getAllUser() {
        if (StpUtil.isLogin()) {
            StpUtil.checkRole("admin");
            List<User> users = userRepository.getAllUser();
            Map<String, Object> map = new HashMap<>();
            map.put("code", 200);
            map.put("msg", "ok");
            map.put("users", users);
            return map;
        } else {
            return SaResult.error();
        }

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
            StpUtil.login(paw.getUserId());
            System.out.println(StpUtil.getLoginId());
            return SaResult.ok("ok").toString();
//            return "ok";
        } else {
//                return "no";
            return SaResult.error("no").toString();
        }
    }

    @Override
    public String logout(User user) {
        User paw = userRepository.login(user);
        if (paw!= null) {
            StpUtil.logout(paw.getUserId());
            return SaResult.ok("ok").toString();
        } else {
            return SaResult.error("no").toString();
        }
    }
}
