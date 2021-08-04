package com.msp.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MyHttpSessionListener implements HttpSessionListener {

    public static final Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    public Integer count = 0;


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("新用户上线了");
        count = count + 1;
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("用户下线了");
        count = count - 1;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
