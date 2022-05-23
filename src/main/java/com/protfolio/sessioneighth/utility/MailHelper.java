package com.protfolio.sessioneighth.utility;

import com.protfolio.sessioneighth.model.Contact;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailHelper {

    public static void sendTextEmail(String message, JavaMailSender javaMailSender){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("taman.neupane@peacenepal.com");

        simpleMailMessage.setSubject("Email from your personal website");

        simpleMailMessage.setText(message);

        try{
            javaMailSender.send(simpleMailMessage);
        }catch (MailException exception){
            exception.printStackTrace();
        }
    }
}
