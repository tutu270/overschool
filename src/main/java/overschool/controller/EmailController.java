package overschool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import overschool.serviceImp.EmailServiceImp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class EmailController {

    @Resource
    EmailServiceImp emailServiceImp;

    @RequestMapping("/111")
    public String sendSimpleEmail(HttpServletRequest request) {
        emailServiceImp.sendSimpleEmail("1435687303@qq.com", request);
        return "发送成功";
    }




}
