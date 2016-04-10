package com.sb.hyh.web;

import java.util.logging.Logger;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.entity.EmailContent;
import com.sb.hyh.service.mail.MailSenderService;

@RestController
public class MailController {
    private Logger logger = Logger.getLogger(MailController.class.getName());
    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String sendMail() {
        try {
            logger.info("sendMail");
            EmailContent emailContent = new EmailContent();
            emailContent.setContent("测试中文");
            emailContent.setTo("");
            mailSenderService.sendMail(emailContent);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
