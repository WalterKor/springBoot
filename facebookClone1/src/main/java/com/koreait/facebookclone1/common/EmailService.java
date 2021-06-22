package com.koreait.facebookclone1.common;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
    void sendMimeMessage(String to, String subject, String text);

}
