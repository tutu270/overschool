package overschool.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ControllerTest {
    @RequestMapping("/1")
    public String WebSocket() {

        return "index";
    }

    @RequestMapping("/loginShow")
    public String loginShow(){
        return "login";
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception{
        GifCaptcha gifCaptcha = new GifCaptcha(130,48,2);
        CaptchaUtil.out(gifCaptcha, request, response);
        String verCode = gifCaptcha.text().toLowerCase();
        request.getSession().setAttribute("CAPTCHA",verCode);  //存入session
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
//    @PostMapping("/login")
//    public String login(String username, String password, String identifyCode, HttpSession session){
//        System.out.println("用户名:"+username);
//        System.out.println("密码:"+password);
//        System.out.println("验证码:"+identifyCode);
//        //从session中取出验证码
//        String sessionCode = (String)session.getAttribute("identifyFyCode");
//        if (identifyCode.equalsIgnoreCase(sessionCode)){
//            System.out.println("验证码正确");
//            //进行登录判断的逻辑大家自己写，这里就不演示了
//        }else{
//            System.out.println("验证码错误");
//            //重定向到登录画面
//            return "redirect:/loginShow";
//        }
//        return "";
//    }




}
