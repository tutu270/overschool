package overschool.service;

import javax.servlet.http.HttpServletRequest;

public interface EmailService {
    public void sendSimpleEmail(String to,  HttpServletRequest request);
}
