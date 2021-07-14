package com.msp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.msp.service.MailService;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(path  = "/sendmail", method  = RequestMethod.GET)
    public String sendmail(){
        mailService.sendSimpleMail("1360311705@qq.com","test","test");
        return "已发送";

    }
}
