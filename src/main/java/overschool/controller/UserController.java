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


//    @GetMapping("captcha")
//    public Result captcha() throws IOException {
//
//        //算术类型
//        ArithmeticCaptcha captcha = new ArithmeticCaptcha();
//
//        //中文类型验证吗
//        //ChineseCaptcha captcha = new ChineseCaptcha();
//
//        // 英文与数字验证码
//        // SpecCaptcha captcha = new SpecCaptcha();
//
//        //英文与数字动态验证码
//        //GifCaptcha captcha = new GifCaptcha();
//
//        //中文动态验证码
//        //ChineseGifCaptcha captcha = new ChineseGifCaptcha();
//        //几位数运算   默认是两位
//        captcha.setLen(2);
//
//        //获取运算结果
//        String result = captcha.text();
//
//        log.info("===============获取运算结果为=========:{}", result);
//
//        String key = UUID.randomUUID().toString();
//        redisTemplate.opsForValue().set(key, result, 2, TimeUnit.MINUTES);
//        Map map = new HashMap();
//        map.put("key", key);
//        map.put("img", captcha.toBase64());
//        return Result.success("图片验证码", map);
//
//    }
}
