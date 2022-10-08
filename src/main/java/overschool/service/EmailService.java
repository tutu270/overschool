package overschool.service;

public interface EmailService {
    public void sendSimpleEmail(String to, String subject, String text);
}
