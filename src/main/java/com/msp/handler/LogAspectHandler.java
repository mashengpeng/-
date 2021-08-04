package com.msp.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspectHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    @Pointcut("execution(* com.msp.controller..*.*(..))")
    public void pointCut() {}


    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("====doBefore方法进入了====");
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funcName = signature.getName();
        logger.info("即将执行方法为: {}，属于{}包", funcName, declaringTypeName);
        // 也可以用来记录一些信息，比如获取请求的url和ip
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取请求url
        String url = request.getRequestURL().toString();
        // 获取请求ip
        String ip = request.getRemoteAddr();
        logger.info("用户请求的url为：{}，ip地址为：{}", url, ip);
        logger.info("====doBefore方法结束了====");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("====doAfterReturning方法进入了====");
        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getName();
        logger.info("方法{}执行完毕，返回参数为：{}", classMethod, result);
        // 实际项目中可以根据业务做具体的返回值增强
        //logger.info("对返回参数进行业务上的增强：{}", result + "增强版");
        logger.info("====doAfterReturning方法结束了====");
    }


    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("====doAfter方法进入了====");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("方法{}已经执行完", method);
        logger.info("====doAfter方法结束了====");
    }


    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        // 处理异常的逻辑
        logger.info("执行方法{}出错，异常为：{}", method, ex);
    }




}

