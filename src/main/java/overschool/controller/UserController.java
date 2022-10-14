package overschool.controller;

import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.web.bind.annotation.*;
import overschool.entity.User;
import overschool.service.UserService;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @ResponseBody
    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    @GetMapping("/getalluser")
    public  Map<String, Object> getAllUser() {
        return userService.getAllUser();
    }

    @ResponseBody
    @PostMapping("/indexUser")
    public User indexUser(@RequestBody User user) {
        return userService.getIndexUser(user);
    }

    @ResponseBody
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return userService.login(user);
    }

    @ResponseBody
    @PostMapping("/logout")
    public String logoutUser(@RequestBody User user) {
        return userService.logout(user);
    }
}
