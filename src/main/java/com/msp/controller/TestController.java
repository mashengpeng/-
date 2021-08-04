package com.msp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@RestController
@RequestMapping("/test")
@Api(value = "Swagger2 在线接口文档")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/log")
    @ApiOperation(value = "测试")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======倪升武的个人博客：{}；倪升武的CSDN博客：{}", str1, str2);
        try {
            int i = 1/0;

        }catch (Exception e){
            throw e;
        }
        return "success";
    }

    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try {
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(),"utf-8"));
            cookie.setPath("/");
            cookie.setMaxAge(48*60*60);
            response.addCookie(cookie);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }


        Integer count = (Integer)request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

}