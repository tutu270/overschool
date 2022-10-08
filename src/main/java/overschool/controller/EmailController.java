package overschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import overschool.service.imp.EmailServiceImp;

import javax.annotation.Resource;

@RestController
public class EmailController {

    @Resource
    EmailServiceImp emailServiceImp;

    @RequestMapping("/111")
    public String sendSimpleEmail() {
        emailServiceImp.sendSimpleEmail("1435687303@qq.com","你是猪！！！","你是猪");
        return "发送成功";
    }




}
