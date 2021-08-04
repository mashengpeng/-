package com.msp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.msp.service.MailService;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(path  = "/sendmail/{subject}", method  = RequestMethod.GET)
    public String sendmail(@PathVariable("subject") String subject){
        mailService.sendSimpleMail("1360311705@qq.com",subject,subject);
        return "邮件已发送，主题为："+subject;

    }
}
