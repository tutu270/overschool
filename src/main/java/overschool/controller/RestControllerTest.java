package overschool.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import overschool.entity.User;

import java.util.concurrent.TimeUnit;

@RestController
public class RestControllerTest {

    @Autowired
    RedisTemplate redisTemplate; //默认提供的用来操作对象的redis操作实例

    @Autowired
    StringRedisTemplate stringRedisTemplate; //默认提供的用来操作字符串的redis操作实例

    @GetMapping("/test")
    public String test() {
        return "测试";
    }

    @RequestMapping("/test1")
    public void test1() {
        //保存一个字符串
        redisTemplate.opsForValue().set(JSON.toJSONString("1234"), JSON.toJSONString("5551"), 5, TimeUnit.MINUTES);

        String code = (String) redisTemplate.opsForValue().get(JSON.toJSONString("1234"));
        System.out.println(code);
    }
}
