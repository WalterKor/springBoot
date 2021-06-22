package com.koreait.facebookclone1.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); //받는사람
        message.setSubject(subject); //제목
        message.setText(text);//내용
        mailSender.send(message); //메세지를 합친거

    }

    @Override
    public void sendMimeMessage(String to, String subject, String text) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {

            helper.setTo(to); //받는사람 이메일 주소
            helper.setSubject(subject);
            helper.setText(text, true); // true넣을 경우 html
            mailSender.send(mimeMessage);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
