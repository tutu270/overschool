package overschool.controller;

import org.springframework.web.bind.annotation.*;
import overschool.entity.User;
import overschool.service.UserService;

import javax.annotation.Resource;
import java.util.List;

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
    public List<User> getAllUser() {
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
}
